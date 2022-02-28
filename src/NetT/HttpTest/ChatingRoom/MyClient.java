package NetT.HttpTest.ChatingRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： 读取用户键盘输入
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 12:11
 * <p>
 * Version: 0.0.1
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("127.0.0.1",30000);
            // 客户端启动ClientThread线程不断地读取来自服务器的数据
          new Thread(new ClientThread(s)).start();
          // 获取该Socket对应的输出流
            PrintStream ps=new PrintStream(s.getOutputStream());
            String line=null;
            // 不断地读取键盘输入
            BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
            while ((line=buffer.readLine())!=null){
                ps.println("====="+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
