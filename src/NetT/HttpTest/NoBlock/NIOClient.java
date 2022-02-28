package NetT.HttpTest.NoBlock;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Package: NetT.HttpTest.NoBlock
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 9:41
 * <p>
 * Version: 0.0.1
 */
public class NIOClient {
    // 定义检测SocketChannel的Selector对象
    private Selector selector = null;
    static final int PORT = 30000;
    // 定义处理编码和解码的字符集
    private Charset charset = Charset.forName("UTF-8");
    // 客户端SocketChannel
    private SocketChannel socketChannel = null;

    public static void main(String[] args) throws IOException {
        new NIOClient().init();
    }

    public void init() throws IOException {
        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
        // 调用open()静态方法创建连接到指定主机的SocketChannel
        socketChannel= SocketChannel.open(isa);
        // 设置该sc以非阻塞方式工作
        socketChannel.configureBlocking(false);
        // 将SocketChannel注册到指定的Selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        // 启动读取服务器端数据的线程
        new ClientThread().start();
        // 创建键盘输入流
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            // 读取键盘输入
            String line=scanner.nextLine();
            // 将键盘输入的内容输出到SocketChannel中
            socketChannel.write(charset.encode(line));
        }


    }

    // 定义读取服务器端数据的线程
    private class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                while (selector.select() > 0) {
                    // 遍历每个有可用IO操作的Channel对应的SelectionKey
                    for (SelectionKey selectionKey : selector.selectedKeys()) {
                        // 删除正在处理的SelecttionKey
                        selector.selectedKeys().remove(selectionKey);
                        // 如果该SelectionKey对应的Chinnel中有可读取的数据
                        if (selectionKey.isReadable()) {
                            // 使用NIO读取Channel的数据
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            String content = "";
                            while (socketChannel.read(buffer) != 0) {
                                socketChannel.read(buffer);
                                buffer.flip();
                                content += charset.decode(buffer);
                            }
                            // 打印输出读取的内容
                            System.out.println("聊天信息" + content);
                            // 为下次读取做准备
                            selectionKey.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
