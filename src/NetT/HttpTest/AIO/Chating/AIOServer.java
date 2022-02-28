package NetT.HttpTest.AIO.Chating;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package: NetT.HttpTest.AIO.Chating
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 11:40
 * <p>
 * Version: 0.0.1
 */
public class AIOServer {
    static final int PORT = 30000;
    // final static String UTF_8 = "utf-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        AIOServer a = new AIOServer();

        a.startListen();

    }

    public void startListen() throws IOException {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(20);
        // 以指定的线程池来创建一个AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        // 以指定的线程池来创建一个AsynchronousServerSocketChannel
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
                // 指定监听本机的PORT端口
                .bind(new InetSocketAddress(PORT));
        // 使用CompletionHandler接受来自客户端的连接请求
        serverChannel.accept(null, new AcceptHander(serverChannel));
        while (true) {
//            System.in.read();
        }
    }

    // 实现自己的CompletionHandler类
    private class AcceptHander implements CompletionHandler<AsynchronousSocketChannel, Object> {
        private AsynchronousServerSocketChannel serverChannel;


        public AcceptHander(AsynchronousServerSocketChannel serverChannel) {
            this.serverChannel = serverChannel;
        }

        // 定义一个ByteBuffer准备读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 当实际IO操作完成时触发该方法
        @Override
        public void completed(final AsynchronousSocketChannel socketChannel, Object attachment) {
            // 记录新连接进来的channel
            AIOServer.channelList.add(socketChannel);
            // 准备接收客户端的下一次连接
            serverChannel.accept(null, this);
            socketChannel.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    byteBuffer.flip();
                    // 将byteBuffer中的内容转换为字符串
                    String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();
                    // 遍历每个Channel,将收到的信息写入各Channel中
                    for (AsynchronousSocketChannel socketChannel : AIOServer.channelList) {
                        try {
                            socketChannel.write(ByteBuffer.wrap(content.getBytes("utf-8"))).get();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                    byteBuffer.clear();
                    // 读取下一次数据
                    socketChannel.read(byteBuffer, null, this);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("读取数据失败" + exc);
                    // 从该Channel中读取数据失败，就将该Channel删除
                    AIOServer.channelList.remove(socketChannel);
                }
            });
        }

        @Override
        public void failed(Throwable exc, Object attachment) {

            System.out.println("连接失败" + exc);
        }
    }
}
