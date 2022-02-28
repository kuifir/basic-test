package NetT.HttpTest.NoBlock;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * Package: NetT.HttpTest.NoBlock
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 8:51
 * <p>
 * Version: 0.0.1
 */
public class NIOServer {
    // 用于检测所有Channel状态的Selector
    private Selector selector = null;
    static final int PORT = 30000;
    // 定义实现编码解码的字符集对象
    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        NIOServer ns = new NIOServer();
        ns.init();
    }

    public void init() throws IOException {
        selector = Selector.open();
        // 通过open()来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.1", PORT);
        // 将该ServerSocketChannel绑定到指定IP地址
        server.bind(isa);
        // 设置ServerSocket以非阻塞方式工作
        server.configureBlocking(false);
        // 将server注册到指定的Selector对象
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            // 依次处理selector上的每个已选择的SelectionKey
            for (SelectionKey selectionKey : selector.selectedKeys()) {
                // 从selector上的已选择key集合中删除正在处理的SelectionKey
                selector.selectedKeys().remove(selectionKey);
                // 如果selectionKey对应的Channel包含客户端的连接请求
                if (selectionKey.isAcceptable()) {
                    // 调用accept方法接受连接，产生服务器端地SocketChannel
                    SocketChannel socketChannel = server.accept();
                    // 设置采用非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 将SocketChannel也注册到selector
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    // 将selectionKey设置成准备接收其他请求
                    selectionKey.interestOps(SelectionKey.OP_ACCEPT);
                }
                // 如果selectionKey对应的Channel有数据需要读取
                if (selectionKey.isReadable()) {
                    // 获取该SelectionKey对应的Channel，该Channel中有可读的数据
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    String content = "";
                    // 开始读取
                    try {
                        while (socketChannel.read(buffer) > 0) {
                            buffer.flip();
                            content += charset.decode(buffer);
                        }
                        // 打印从该selectionKey对应的Channel里读取到的数据
                        System.out.println("读取的数据"+content);
                        // 将selectionKey对应的Channel设置成准备下一次读取
                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                    // 如果捕获到该selectionKey对应的Channel出现了异常，即表明该Channel
                    // 对应的Client出现了问题，所以从Selector中取消selectionKey的注册
                    catch (IOException e){
                        // 从Selecot中删除指定的SelectionKey
                        selectionKey.cancel();
                        if(selectionKey.channel()!=null){
                            selectionKey.channel().close();
                        }
                    }
                    // 如果content的长度大于0，及聊天信息不为空
                    if (content.length()>0){
                        // 遍历该Selector里注册的所有SelectionKey
                        for (SelectionKey selectionKey1:selector.keys()){
                            // 获取该selectionKey对应的Channel
                            Channel targetChannek=selectionKey1.channel();
                            // 如果该Channel是SocketChannel对象
                            if(targetChannek instanceof SocketChannel){
                                // 将读到的内容写入该Channel中
                                SocketChannel dest= (SocketChannel) targetChannek;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }

        }
    }
}
