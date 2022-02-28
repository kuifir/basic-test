package IOTest.StreamTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： 处理流
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 15:02
 * <p>
 * Version: 0.0.1
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try (

                FileOutputStream fos = new FileOutputStream("test.txt");
                PrintStream ps = new PrintStream(fos);
        ) {
            ps.println("ss");
            ps.println(new PrintStreamTest());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
