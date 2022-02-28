package ScannerTest;

import java.util.Scanner;

/**
 * Package: ScannerTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 15:48
 * <p>
 * Version: 0.0.1
 */
public class ScannerTest {
    public static void main(String[] args) {
        // System.in 代表标准输入 就是键盘输入
        Scanner sc =new Scanner(System.in);
        // 增加下面一行将之把回车设置为分隔符
        sc.useDelimiter("\n");
        // 判断是否还有下一个输入项
        while (sc.hasNext()){
            System.out.println("键盘输入的内容是："+sc.next());
        }
    }
}
