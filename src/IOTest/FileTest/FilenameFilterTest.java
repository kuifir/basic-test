package IOTest.FileTest;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Package: IOTest
 * <p>
 * Description： 文件过滤器
 * File类的lsit()方法中可以接收一个FilenameFilter参数。通过这个参数可以只列出符合条件的文件
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/22 14:33
 * <p>
 * Version: 0.0.1
 */
public class FilenameFilterTest {
    public static void main(String[] args) {
        File file = new File(".");
        // 使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤器
        // 如果文件名以.java结尾，或者文件对应一个路径，则返回true
        String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
        for (String name : nameList) {
            System.out.println(name);
        }
    }
}
