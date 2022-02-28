package IOTest.StreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Package: IOTest.StreamTest
 * <p>
 * Description： 重定向标准输入
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/22 19:25
 * <p>
 * Version: 0.0.1
 */
public class RedirectIn {
    public static void main(String[] args) {
        try (
                FileInputStream fis =new FileInputStream("src\\IOTest\\StreamTest\\RedirectIn.java")
                ){
            // 将标准输入重定向到 fis
            System.setIn(fis);
            // 使用System.in创建Scanner对象，用于获取标准输入
            Scanner scanner = new Scanner(System.in);
            // 增加下面一行，只把回车当分隔符
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                System.out.println("键盘输入内容是"+scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
