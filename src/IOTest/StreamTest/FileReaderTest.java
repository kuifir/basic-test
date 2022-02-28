package IOTest.StreamTest;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        // 创建字符输入流
        FileReader fr = new FileReader("src\\IOTest\\StreamTest\\FileReaderTest.java");
        // 创建一个长度为32的竹筒
        char[] cbuf = new char[32];
        // 用于保存实际读取的字符数
        int hasread = 0;
        try {
            // 循环来重复取水过程
            while ((hasread = fr.read(cbuf)) > 0) {
                // 取出字符数组中的字符，并转换成字符串输入
                System.out.print(new String(cbuf,0,hasread));
//                System.out.print(new String(cbuf));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally{
            fr.close();
        }
    }
}
