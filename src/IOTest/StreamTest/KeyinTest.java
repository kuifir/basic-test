package IOTest.StreamTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Package: PACKAGE_NAME
 * Description： 转换流
 * System.in 默认是InputStream类实例
 * InputStreamReader和OutputStreamWriter将字节流转换成字符流
 * 普通的Reader读取输入内容时依然不太方便，可以将普通的Reader再次包装成BufferedReader
 * 利用BufferedReader的readLine方法可以一次读取一行的内容
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 15:25
 * <p>
 * Version: 0.0.1
 */
public class KeyinTest {
    public static void main(String[] args) {
        try (
                // 将System.in对象转换成Reader对象
                InputStreamReader isr = new InputStreamReader(System.in);
                // 将普通的Reader包装成BufferedReader
                BufferedReader bufe = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = bufe.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容为---" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
