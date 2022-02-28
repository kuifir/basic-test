package exceptionTest.finallyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Package: exceptionTest
 * <p>
 * Description： finally测试
 * 除非在try块catch块使用了推出虚拟机的方法，finally总是会执行
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 13:43
 * <p>
 * Version: 0.0.1
 */
public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream fis =null;
        try {
            fis = new FileInputStream("b.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            // return 语句强制返回
            return;
            // 使用exit()退出虚拟机
//            System.exit(1); //退出新虚拟机finally不会执行
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("执行finally块里的资源回收");
        }
    }
}
