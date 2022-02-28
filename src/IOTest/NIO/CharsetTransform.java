package IOTest.NIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Package: IOTest.NIO
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 16:45
 * <p>
 * Version: 0.0.1
 */
public class CharsetTransform {
    public static void main(String[] args) throws CharacterCodingException {
        // 创建简体中文对应的Charset
        Charset cn =Charset.forName("GBK");
        // 获取cn对象对应的编码器和解码器
        CharsetEncoder cnEncoder = cn.newEncoder();
        CharsetDecoder cnDecoder = cn.newDecoder();
        // 创建一个CharBuffer对象
        CharBuffer cbuff = CharBuffer.allocate(8);
        cbuff.put('赵');
        cbuff.put('钱');
        cbuff.put('孙');
        cbuff.flip();
        // 将CharBuffer中的字符序列转换成字节序列
        ByteBuffer bbuff = cnEncoder.encode(cbuff);
        // 循环访问每一个ByteBuffer的每个字节
        for (int i =0;i<bbuff.capacity();i++){
            System.out.println(bbuff.get(i));
        }
        // 将ByteBuffer的数据解码成字符序列
        System.out.println("\n"+cnDecoder.decode(bbuff));
    }
}
