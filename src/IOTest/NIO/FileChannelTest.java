package IOTest.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 12:15
 * <p>
 * Version: 0.0.1
 */
public class FileChannelTest {
    // 将FileChannel的全部数据映射成ByteBuffer
    public static void main(String[] args) {
        File file=new File("src\\IOTest\\NIO\\FileChannelTest.java");
        try (
                // 创建FileInputStream，以该文件输入流创建FileChannel
                FileInputStream fis=new FileInputStream(file);
                FileChannel inChannel=fis.getChannel();
                // 以文件输出流创建FileChannel，用以控制输出
                FileChannel outChannel=new FileOutputStream("outChannel.txt").getChannel();
        ){
            // 将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer mbbuff=inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            //使用UTF-8来创建解码器
            Charset charset=Charset.forName("UTF-8");
            // 直接将buffer里的数据全部输出
            outChannel.write(mbbuff);
            // 再次调用buffer的clear()方法，复原limit\position的位置
            mbbuff.clear();
            //创建解码器对象
            CharsetDecoder decoder=charset.newDecoder();
            //使用解码器将ByteBuffer转码成charbuffer对象
            CharBuffer charBuffer=decoder.decode(mbbuff);
            // CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
