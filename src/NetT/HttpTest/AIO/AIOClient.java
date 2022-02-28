package NetT.HttpTest.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

/**
 * Package: NetT.HttpTest.AIO
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 11:22
 * <p>
 * Version: 0.0.1
 */
public class AIOClient {
    static  final int PORT=30000;
    public static void main(String[] args) {
        // 用于读取数据的ByteBuffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        Charset utf=Charset.forName("UTF-8");
        try{
            // 创建AsynchronousSocketChannel对象
            AsynchronousSocketChannel clientChannel=AsynchronousSocketChannel.open();
            //write(),read(),connect都有两个版本，一个返回Future，必须需要get()后才能操作;一个需要传入CompletionHander参数
            // 连接远程服务器
            // 必须使用.get()，因为没有传入CompletionHander，
            // 因此程序无法通过该监听器在IO操作完成时触发特定的动作
            // 程序必须调用Future返回值的get()方法，并等到get()方法完成才能确定异步IO操作已经执行完成
            clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
            buffer.clear();
            // 从clientChannel中读取数据
            clientChannel.read(buffer).get();// 必须使用.get()
            buffer.flip();
            // 将buff中的内容转换为字符串
            String content=utf.decode(buffer).toString();
            System.out.println("服务器信息"+content);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
