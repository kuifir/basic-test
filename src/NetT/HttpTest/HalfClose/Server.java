package NetT.HttpTest.HalfClose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Package: NetT.HttpTest.HalfClose
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 18:16
 * <p>
 * Version: 0.0.1
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(30000);
            Socket s = serverSocket.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("ddddd");
            ps.println("dddd");
            // 关闭socket的输出流，表明输出数据已结束
            s.shutdownOutput();
            // 下面语句将输出false，表面那个socket还未关闭
            System.out.println(s.isClosed());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String content = null;
            while ((content = br.readLine()) != null) {
                ps.println(content);
            }
            ps.close();
            br.close();
            s.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
