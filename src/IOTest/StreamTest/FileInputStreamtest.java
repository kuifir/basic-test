package IOTest.StreamTest;

import com.sun.xml.internal.ws.addressing.ProblemAction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * InputStream和Reader都是抽象类，本身不能创建实例，
 * 但分别有一个创建读取文件的输入流：FileInputStream和FileReader
 * 他们都是节点流——会直接和指定文件关联
 */
public class FileInputStreamtest {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流
        FileInputStream fis = new FileInputStream("G:\\code\\workspace\\src\\IOTest\\StreamTest\\FileInputStreamtest.java");
        // 创建一个长度为1024的“竹筒”
        byte[] bbuf = new byte[1024];
//        byte[] bbuf = new byte[10];
        // 用于保存实际读取的字节数
        int hasread = 0;
        try {
            // read(byte[] b)从输入流中最多读取b.legth个字节的数据，并将其存储在b中，返回实际读取的字节数
            // 使用循环来重复读取的过程
            // 文件比较小，只需执行一次read()方法，如果bbuf的长度比较小，可能会乱码，
            // 因为中文字符占两个字节，如果只读取到半个中文字符，将导致乱码
            while ((hasread = fis.read(bbuf)) > 0) {
                System.out.print(new String(bbuf, 0, hasread));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文件输入流
            fis.close();
        }
    }
}
