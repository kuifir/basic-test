package NetT.HttpTest.ChatingRoom;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： 读取Socket的输入流内容，并将这些内容打印在控制台
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 13:27
 * <p>
 * Version: 0.0.1
 */
public class ClientThread implements Runnable {
    // 该线程负责处理的Socket
    private Socket s;
    // 该线程所处理的Socket对应的输入流
    private BufferedReader br = null;

    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content = null;
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
