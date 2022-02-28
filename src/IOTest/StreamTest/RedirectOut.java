package IOTest.StreamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Package: IOTest.StreamTest
 * <p>
 * Description： 重定向标准输出
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/22 19:18
 * <p>
 * Version: 0.0.1
 */
public class RedirectOut {
    public static void main(String[] args) {
        try (
                // 一次性创建PrintStream
                PrintStream ps =new PrintStream(new FileOutputStream("out.txt"))
                ){
            // 向标准输入重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("一个字符串");
            // 向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
