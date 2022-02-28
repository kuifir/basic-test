package NetT.HttpTest.ChatingRoom;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 14:45
 * <p>
 * Version: 0.0.1
 */
public class Server {
    private  static final int SERVER_PORT=30000;
    // 使用ClientMap对象来保存每个客户名字和对应输出流之间的对应关系
    public  static ClientMap<String, PrintStream>clients=new ClientMap<>();

    public static void main(String[] args) {
        Server server=new Server();
        server.init();
    }
    public void init(){
        try(
                // 建立监听的ServerSocke
                ServerSocket ss=new ServerSocket(SERVER_PORT);) {
            // 采用死循环来不断的接收来自客户端的请求
           while (true){
               Socket socket= ss.accept();
               new ServerThread2(socket).start();
           }
        } catch (IOException e) {
            System.out.println("服务启动失败，是否端口"+SERVER_PORT+"被占用");
            e.printStackTrace();
        }
    }
}
