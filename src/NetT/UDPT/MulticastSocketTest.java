package NetT.UDPT;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Package: NetT.UDPT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 23:32
 * <p>
 * Version: 0.0.1
 */
// 让该类实现Runnable接口，该类的实例可作为线程的target
public class MulticastSocketTest implements Runnable {
    // 使用常量作为本程序的多点广播IP地址
    private static final String BROADCAST_IP = "230.0.0.1";
    // 使用常量作为本程序的多点广播目的端口
    public static final int BROADCAST_PORT = 30000;
    // 定义每个数据包的大小最大为4KB
    public static final int DATA_LEN = 4096;

    // 定义本程序的MulticastSocket实例
    public MulticastSocket multicastSocket = null;
    private InetAddress broadcastAddress = null;
    private Scanner scanner = null;

    // 定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];
    // 已指定的字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    // 定义一个用于发送的DatagramPack对象
    private DatagramPacket outPacket = null;

    public static void main(String[] args) {
        new MulticastSocketTest().init();
    }


    public void init() {
        try (
                // 创建键盘输入流
                Scanner scanner = new Scanner(System.in);
        ) {
            // 创建用于发送接收数据的MulticastSocket对象
            // 由于该MulticastSocket对象需要接收数据，所以有指定接口
            multicastSocket = new MulticastSocket(BROADCAST_PORT);
            broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            // 将该socket加入指定的多点广播地址
            multicastSocket.joinGroup(broadcastAddress);
            //设置本multicastSocket发送的数据报会被会送到本身
            multicastSocket.setLoopbackMode(false);
            // 初始化发送用的DatagramSocket，它包含一个长度为0的字节数组
            outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
            // 启动本实例的run()方法作为线程执行体的线程
            new Thread(this).start();
            // 不断地读取键盘输入
            while (scanner.hasNext()) {
                byte[] buff = scanner.nextLine().getBytes();
                outPacket.setData(buff);
                multicastSocket.send(outPacket);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            multicastSocket.close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 读取Socket中的数据，独到的数据放在inPacket所封存的字节数组里
                multicastSocket.receive(inPacket);
                // 打印出从socket中读取的内容
                System.out.println("聊天信息" + new String(inBuff, 0, inPacket.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (multicastSocket != null) {
                    multicastSocket.leaveGroup(broadcastAddress);
                    multicastSocket.close();
                }
                System.exit(1);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
