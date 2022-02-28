package ScannerTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Package: ScannerTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 15:57
 * <p>
 * Version: 0.0.1
 */
public class ScaanerFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc =new Scanner(new File("src//ScannerTest//ScaanerFileTest.java"));
        System.out.println("ScannerFileTest.java 内容如下：");
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
