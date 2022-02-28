package NetT.HttpTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Package: NetT.HttpTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 12:11
 * <p>
 * Version: 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 创建连接到本机30000端口的Socket
            Socket s=new Socket("127.0.0.1",30000);
            String str="";

            PrintStream ps=new PrintStream(s.getOutputStream());
            ps.println("这是客户");
            // 将Socket对应的输入流包装成BufferedReader
            BufferedReader buffer=new BufferedReader(new InputStreamReader(s.getInputStream()));
            while ((str=buffer.readLine())!=null){
                System.out.println("来自服务器"+str);
                str=null;
            }
            s.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
