package NetT.HttpTest.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Package: NetT.HttpTest.AIO
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 11:12
 * <p>
 * Version: 0.0.1
 */
public class AIOServer {
    static final int PORT = 30000;

    public static void main(String[] args) {
        try (
                // 创建AsynchronousServerSocketChannel对象
                AsynchronousServerSocketChannel serverSocketChannel =
                        AsynchronousServerSocketChannel.open();
        ) {
            // 指定在指定地址、端口监听
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            while (true) {
                //循环调用接受来自客户端的连接
                Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
                // 获取连接完成后返回的AsynchronousSocketChannel
                AsynchronousSocketChannel socketChannel = future.get();
                // 执行输出
                socketChannel.write(ByteBuffer.wrap(("欢迎来到AIO").getBytes("UTF-8"))).get();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
