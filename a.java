package IOTest.StreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                // 创建字节输入流
                FileInputStream fis = new FileInputStream("src\\IOTest\\StreamTest\\FileOutputStreamTest.java");
                // 创建字节输出流
                FileOutputStream fos = new FileOutputStream("a.java")) {
            byte[] bbuf = new byte[1024];
            int hasread = 0;
            while ((hasread = fis.read(bbuf)) > 0) {
                // 每读取一次，即写入文件输入流，读了多少，写多少
                fos.write(bbuf, 0, hasread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
