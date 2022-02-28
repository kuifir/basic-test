package NetT.HttpTest.ChatingRoom;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： 负责处理每个线程通信的线程类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 12:59
 * <p>
 * Version: 0.0.1
 */
public class ServerThread implements Runnable {
    // 定义当前线程所处理的Socket
    private Socket s = null;
    // 该线程所处理的Socket对应的输出流
    private BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        // 初始化该Socket对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    // 定义读取客户端数据的方法
    private String readFromClient() {
        try {
            return br.readLine();
        }
        // 如果捕获到异常，则表明该Socket对应的客户端已关闭
        catch (IOException e) {
            // 删除该Socket
            MyServer.socketList.remove(s);
            System.out.println("用户退出");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        try {
            String content = null;
            // 采用循环不断地从Socket中读取客户端发送过来的数据
            while ((content = readFromClient()) != null) {
                for (Socket s : MyServer.socketList) {
                    PrintStream ps = null;

                    ps = new PrintStream(s.getOutputStream());

                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
