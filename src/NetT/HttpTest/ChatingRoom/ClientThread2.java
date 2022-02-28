package NetT.HttpTest.ChatingRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 13:27
 * <p>
 * Version: 0.0.1
 */
public class ClientThread2 extends Thread {
    //private Socket s;
    // 该客户端线程负责处理的输入流
    private BufferedReader br = null;

    // 使用一个网络输入流来创建客户端线程
    public ClientThread2(BufferedReader br) {
        this.br = br;

    }

    @Override
    public void run() {
        try {
            String content = null;
            // 不断地输入流中读取数据，并将这些数据打印输出
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
