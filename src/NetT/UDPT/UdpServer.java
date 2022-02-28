package NetT.UDPT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Package: NetT.UDPT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 22:11
 * <p>
 * Version: 0.0.1
 */
public class UdpServer {
    public static final int PORT = 30000;
    // 定义每个数据报的大小最大为4KB
    private static final int DATA_LEN = 4096;
    // 定义接收网络数据的字节数组
    byte[] inbuff = new byte[DATA_LEN];
    // 以指定字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inbuff, inbuff.length);
    // 定义一个字符串数组，服务器端发送该数组的元素
    private DatagramPacket outPacket;
    // 定义一个字符串数组，服务器端发送该数组元素
    String[] msg = new String[]{"看iOK吗", "发v你软件开发部", "啊的发挥","sfcsdrw"};

    public static void main(String[] args) {
        new UdpServer().init();
    }
    public void init() {
        try {
            // 创建DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket(PORT);
            // 采用循环接收数据
            for (int i = 0; i < 100; i++) {
                // 读取socket中的数据，读到的数据刚入inPack封装的数组里
                datagramSocket.receive(inPacket);
                // 判断inPack.getData()和inBuff是否是同一个数组
                System.out.println(inbuff==inPacket.getData());
                // 将接收到的内容转换成字符串后输出
                System.out.println(new String(inbuff,0,inPacket.getLength()));
                // 从数组中取出一个元素作为发送数据
                byte[] sendData =msg[i%4].getBytes();
                // 以指定的字节数组作为发送数据，以刚接收到的DatagramPacker的
                // 源SocketAddress作为目标SocketAddress创建DatagramPacket
                outPacket=new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
                // 发送数据
                datagramSocket.send(outPacket);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
