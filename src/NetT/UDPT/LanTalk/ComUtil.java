package NetT.UDPT.LanTalk;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 * Package: NetT.UDPT.LanTalk
 * <p>
 * Description： 聊天交换信息的工具类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/2 9:46
 * <p>
 * Version: 0.0.1
 */
public class ComUtil {
    // 多点广播ip地址
    private static final String BROADCAST_IP = "230.0.0.1";
    // 多点广播端口
    public static final int BROADCAST_PORT = 30000;
    // 每个数据报最大为4K
    public static final int DATA_LEN = 4096;
    // 创建相应实例
    private MulticastSocket multicastSocket;
    // 私聊使用的实例
    private DatagramSocket datagramSocket;
    // 定义广播的IP地址
    private InetAddress broadcastAddress;
    // 接受书记的字节数组
    private byte[] inBuff = new byte[DATA_LEN];
    // 接收数据的datagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    // 定义一个用于发送数据的datagramPacket对象
    private DatagramPacket outPacket;
    // 聊天主界面程序
    private LanTalk lanTalk;

    // 构造器，初始化资源
    public ComUtil(LanTalk lanTalk) throws IOException, InterruptedException {
        this.lanTalk = lanTalk;
        // 创建用于发送、接收数据的MulticastSocket对象
        // 因为该MulticastSocket对象需要接收数据，所以有指定接口
        multicastSocket = new MulticastSocket(BROADCAST_PORT);
        // 创建私聊用的DatagramSocket对象
        datagramSocket = new DatagramSocket(BROADCAST_PORT + 1);
        broadcastAddress = InetAddress.getByName(BROADCAST_IP);
        //将该socket加入指定的多点广播地址
        multicastSocket.joinGroup(broadcastAddress);
        //设置本MulticastSocket发送的数据包可以发给自己
        multicastSocket.setLoopbackMode(false);
        // 初始化发送用的DatagrameSocket，它包含一个长度为0的数组
        outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
        // 启动两个读取网络数据的线程
        new ReadMulticastSocket().start();
        Thread.sleep(1);
        new ReadDatagramSocket().start();
    }
    // 广播消息的工具方法
    public void broadCast(String msg) {
        try {
            // 将msg字符串转换成字节数组
            byte[] buff = msg.getBytes();
            // 设置发送用的DatagramPacket里的字节数据
            this.outPacket.setData(buff);
            // 发送数据报
            multicastSocket.send(this.outPacket);
        }
        // 捕获异常
        catch (IOException var3) {
            var3.printStackTrace();
            if (multicastSocket != null) {
                // 关闭该Socket对象
                multicastSocket.close();
            }

            JOptionPane.showMessageDialog((Component) null, "发送信息异常，请确认30000端口空闲，且网络连接正常！", "网络异常", 0);
            System.exit(1);
        }

    }

    // 定义向单独用户发送消息的方法
    public void sendSingle(String text, SocketAddress dest) {
        try {
            // 把字符串转换成字节数组
            byte[] buff = text.getBytes();
            DatagramPacket packet = new DatagramPacket(buff, buff.length, dest);
            this.datagramSocket.send(packet);
        }
        // 捕获异常
        catch (IOException var5) {
            var5.printStackTrace();
            if (datagramSocket != null) {
                // 关闭Socket对象
                datagramSocket.close();
            }

            JOptionPane.showMessageDialog((Component) null, "发送信息异常，请确认30001端口空闲，且网络连接正常！", "网络异常", 0);
            System.exit(1);
        }
    }

    // 持续读取MulticastSocket的线程
    class ReadMulticastSocket extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 读取Socket中的数据
                    multicastSocket.receive(inPacket);
                    // 打印输出从Socket中读取的内容
                    String msg = new String(inPacket.getData(), 0, inPacket.getLength(), "utf-8");
                    // 读到的内容是在线信息
                    if (msg.startsWith(YeekuProtocol.PRESENCE) && msg.endsWith(YeekuProtocol.PRESENCE)) {
                        String userMsg = msg.substring(2, msg.length() - 2);
                        String[] userInfo = userMsg.split(YeekuProtocol.SPLITTER);
                        UserInfo user = new UserInfo(userInfo[1], userInfo[0], ComUtil.this.inPacket.getSocketAddress(), 0);
                        // 控制是否需要添加该用户的旗帜
                        boolean addFlag = true;
                        ArrayList delList = new ArrayList();

                        // 循环遍历系统中已有的所有用户
                        for (int i = 1; i < ComUtil.this.lanTalk.getUserNum(); i++) {
                            UserInfo current = ComUtil.this.lanTalk.getUser(i);
                            // 将所有用户失去联系的次数加一
                            current.setLost(current.getLost() + 1);
                            // 如果该信息有指定用户发送
                            if (current.equals(user)) {
                                current.setLost(0);
                                // 设置该用户无需添加
                                addFlag = false;
                            }

                            if (current.getLost() > 2) {
                                delList.add(i);
                            }
                        }

                        // 删除delList中的所有索引对应的用户
                        for (int i = 0; i < delList.size(); ++i) {
                            ComUtil.this.lanTalk.removeUser((Integer) delList.get(i));
                        }

                        if (addFlag) {
                            // 添加新用户
                            ComUtil.this.lanTalk.addUser(user);
                        }
                    }
                    // 读到的内容是公聊信息
                    else {
                        // 处理读到的消息内容
                        lanTalk.processMsg(inPacket, false);
                    }
                } catch (IOException var9) {
                    var9.printStackTrace();
                    if (multicastSocket != null) {
                        multicastSocket.close();
                    }

                    JOptionPane.showMessageDialog((Component) null, "接收信息异常，请确认30000端口空闲，且网络连接正常！", "网络异常", 0);
                    System.exit(1);
                }
            }
        }
    }

    // 持续从Datagramsocket中读取数据的线程
    class ReadDatagramSocket extends Thread {
        // 定义接收网络数据的字节数组
        byte[] singleBuff = new byte[4096];
        private DatagramPacket datagramPacket = new DatagramPacket(singleBuff, singleBuff.length);


        public void run() {
            while (true) {
                try {
                    // 读取socket中的数据
                    datagramSocket.receive(datagramPacket);
                    // 处理读到的消息内容
                    ComUtil.this.lanTalk.processMsg(datagramPacket, true);
                } catch (IOException var2) {
                    var2.printStackTrace();
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }

                    JOptionPane.showMessageDialog((Component) null, "接收信息异常，请确认30001端口空闲，且网络连接正常！", "网络异常", 0);
                    System.exit(1);
                }
            }
        }
    }
}

