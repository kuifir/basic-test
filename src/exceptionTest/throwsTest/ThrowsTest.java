package exceptionTest.throwsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Package: exceptionTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 14:27
 * <p>
 * Version: 0.0.1
 */
public class ThrowsTest {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("b.txt");
    }
}
