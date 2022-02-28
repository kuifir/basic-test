package NetT.HttpTest.ChatingRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 12:08
 * <p>
 * Version: 0.0.1
 */
public class MyServer {
    // 定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> socketList= Collections.synchronizedList((new ArrayList<>()));
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(30000);
            while (true){
                // 此代码会阻塞，将一直等待别人的链接
                Socket s=ss.accept();
                socketList.add(s);
                // 每当客户端连接后，启动一个ServerThread线程为该客户端服务
               new Thread(new ServerThread(s)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
