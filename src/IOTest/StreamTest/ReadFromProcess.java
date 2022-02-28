package IOTest.StreamTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： 读取其他进程的输出信息
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 16:58
 * <p>
 * Version: 0.0.1
 */
public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        // 运行javac命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        try (
                // 以p进程的错误流创建BufferedReader对象
                // 这个错误流对本程序是输入流，对p进程则是输出流
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()))
        ) {
            String buff = null;
            // 采用循环方式来读取p进程的错误输出
            while ((buff = br.readLine()) != null) {
//                System.out.println(new String(buff.getBytes("UTF-8")));
                System.out.println(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
