package exceptionTest;

import java.io.*;

/**
 * Package: exceptionTest
 * <p>
 * Description： java7增强了try语句的功能--允许在try关键字后紧跟一对圆括号，
 * 圆括号可以声明初始化一个或多个资源，try语句在该语句结束时自动关闭这些资源
 * 这些资源必须实现AutoCloseable或Closeable接口
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 14:13
 * <p>
 * Version: 0.0.1
 */
public class AutoCloseTest {
    public static void main(String[] args) {
        try (
                // 声明、初始化两个可关闭的资源
                // try会自动关闭这两个资源
                BufferedReader br = new BufferedReader(new FileReader("src/exceptionTest/AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new FileOutputStream("c.txt"))
        ) {
//            使用两个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
