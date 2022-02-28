package IOTest.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Package: IOTest.NIO
 * <p>
 * Description： buffer多次读取channel
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 16:01
 * <p>
 * Version: 0.0.1
 */
public class ReadFile {
    public static void main(String[] args) {
        try (
                // 创建文件输入流
                FileInputStream fis = new FileInputStream(new File("src\\IOTest\\NIO\\ReadFile.java"));
                // 创建一个FileChannel
                FileChannel fcin = fis.getChannel();
        ) {
            // 定义一个ByteBuffer对象，用于重复取水
            ByteBuffer bbuff =ByteBuffer.allocate(256);
            // 将FileChannel中的数据放入ByteBuffer中
            while (fcin.read(bbuff)!=-1){
                // 锁定Buffer的空白区
                bbuff.flip();
                // 创建Charset对象
                Charset charset =Charset.forName("UTF-8");
                // 创建解码器
                CharsetDecoder decoder = charset.newDecoder();
                // 将ByteBuffer的内容转码
                CharBuffer charBuffer =decoder.decode(bbuff);
                System.out.println(charBuffer);
                // 将Buffer初始化，为下一次读取数据做准备
                bbuff.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
