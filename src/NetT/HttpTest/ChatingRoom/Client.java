package NetT.HttpTest.ChatingRoom;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 16:13
 * <p>
 * Version: 0.0.1
 */
public class Client {
    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;

    public static void main(String[] args) {
        Client client = new Client();
        client.init();
        client.readAndSend();

    }


    private void init() {
        try {
            // 初始化代表键盘的输入流
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            // 连接到服务器
            socket = new Socket("127.0.0.1", SERVER_PORT);
            // 获取该Socket对应的输入流和输出流
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            // 采用循环不断地弹出对话框要求输入用户名
            while (true) {
                String username = JOptionPane.showInputDialog(tip + "输入用户名");
                // 用户输入的用户名前后增加协议字符串后发送
                ps.println(MyProtocol.USER_ROUND + username + MyProtocol.USER_ROUND);
                // 读取服务器端的响应
                String result = brServer.readLine();
                // 如果用户名重复则开始下次循环
                if (result.equals(MyProtocol.NAME_REP)) {
                    tip = "用户名登陆重复";
                    continue;
                }
                // 如果服务器返回登陆成功，则结束循环
                if (result.equals(MyProtocol.LOGIN_SUCCESS)) {
                    new ClientThread2(brServer).start();
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("服务器找不到");
            closeRs();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("网络异常");
            closeRs();
            System.exit(1);
        }
    }

    private void readAndSend() {
        try {
            String line = null;
            // 不断读取键盘输入
            while ((line = keyIn.readLine()) != null) {
                // 如果发送的信息中有":"，且以”//“开头，则认为是想发送私聊信息
                if (line.indexOf(":") > 0 && line.startsWith("//")) {
                    line = line.substring(2);
                    ps.println(MyProtocol.PRIVATE_ROUND + line.split(":")[0]
                            + MyProtocol.SPLIT_SIGN + line.split(":")[1] + MyProtocol.PRIVATE_ROUND);
                } else {
                    ps.println(MyProtocol.MSG_ROUND + line + MyProtocol.MSG_ROUND);
                }
            }
        } catch (IOException e) {
            System.out.println("网络异常重新登陆");
            closeRs();
            e.printStackTrace();
        }
    }

    private void closeRs() {
        try {
            if (keyIn != null) {
                keyIn.close();
            }
            if (brServer != null) {
                brServer.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
