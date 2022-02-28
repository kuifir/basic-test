package NetT.UDPT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Package: NetT.UDPT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 22:25
 * <p>
 * Version: 0.0.1
 */
public class UdpClient {
    // 定义发送数据报的目的地
    public static final int DEST_PORT = 30000;
    public static final String DEST_IP = "127.0.0.1";
    // 定义每个数据白的大小最大为4KB
    public static final int DATE_LEN = 4096;
    // 定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATE_LEN];
    // 以指定的字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    // 定义一个用于发送的DatagramePacket对象
    private DatagramPacket outPacket = null;

    public static void main(String[] args) {
        new UdpClient().init();
    }

    public void init() {
        try (
                // 创建一个客户端DatagramePacket,使用随机接口
                DatagramSocket datagramSocket = new DatagramSocket();
        ) {

            // 初始化发送用的DatagrameSocket，它包含一个长度为0的字节数组
            outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), DEST_PORT);
            // 创建键盘输入流
            Scanner scanner = new Scanner(System.in);
            // 不断读取键盘输入
            while (scanner.hasNext()) {
                // 将键盘输入的一行字符串转换为字节数组
                byte[] buff = scanner.nextLine().getBytes();
                // 设置发送用的DatagramePacket中的字节数据
                outPacket.setData(buff);
                // 发送数据报
                datagramSocket.send(outPacket);
                // 读取Socket中的数据，读到的数据放在inPacket所封装的数组中
                datagramSocket.receive(inPacket);
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
            }


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
