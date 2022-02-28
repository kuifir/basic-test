package NetT.HttpTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Package: NetT.HttpTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 12:08
 * <p>
 * Version: 0.0.1
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 创建一个ServerSocket，用于监听客户端Socket的连接请求
            ServerSocket ss=new ServerSocket(30000);
            // 采用循环不断地接受来自客户端的请求
            while (true){
                // 每当接收到客户端Socket的请求时，服务器也对应产生一个Socket
                Socket s=ss.accept();
                // 将Socket对应的输出流包装成PrintStream
                PrintStream ps=new PrintStream(s.getOutputStream());
                // 进行普通IO操作
                ps.println("这是服务器");
                BufferedReader buffer=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String str="";
                System.out.println("来自用户"+buffer.readLine());
               /* while ((str=buffer.readLine())!=null){
                    System.out.println("来自用户"+str);
                }*/
                ps.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
