package exceptionTest.throwsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Package: exceptionTest.ThrowsTest
 * <p>
 * Description： 一个方法带了throws声明，调用者调用时要么处于try...catch中，要么带throws声明
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 14:30
 * <p>
 * Version: 0.0.1
 */
public class ThrowsTest2 {
    public static void main(String[] args) throws FileNotFoundException {
        test();
    }
    public static void test() throws FileNotFoundException {
        // 因为FileInputStream 的构造器声明抛出FileNotFoundException异常
        // 所以调用FileInputStream 的代码要么处于try...catch中
        // 要么处于另一个带throws声明抛出的方法中
        FileInputStream fis = new FileInputStream("b.txt");

    }
}
