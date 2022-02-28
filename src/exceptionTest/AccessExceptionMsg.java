package exceptionTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Package: exceptionTest
 * <p>
 * Description： 获取异常信息
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 13:43
 * <p>
 * Version: 0.0.1
 */
public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            FileInputStream fis =new FileInputStream("b.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
