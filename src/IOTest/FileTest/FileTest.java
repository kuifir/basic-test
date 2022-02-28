package IOTest.FileTest;

import java.io.File;
import java.io.IOException;

/**
 * File类常用方法
 */

public class FileTest {
    public static void main(String[] args) throws IOException {
        // 以当前路径来创建一个File对象
        File file = new File(".");
        // 直接获取文件名，输出一点
        System.out.println(file.getName());
        //
        System.out.println(file.getPath());
        // 获取相对路径的父路径可能出错，下面代码输出null
        System.out.println(file.getParent());
        // 获取绝对路径
        System.out.println(file.getAbsoluteFile());
        // 获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //===========================================================================
        // 在当前路径下创建一个临时文件
        File tempfile = File.createTempFile("aaa", ".txt", file);
        // 指定在JVM退出时删除该文件
        tempfile.deleteOnExit();
        // 以系统当前时间作为新文件名来创建文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在====" + newFile.exists());
        // 以指定newFile来创建一个文件
        newFile.createNewFile();
        // 以指定newFile来创建一个目录，因为newFile已存在所以下面方法返回false，即无法创建该目录
        System.out.println("是否能够创建文件夹"+newFile.mkdir());
        //============================================================================
        // 使用list()方法列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("当前路径下所有文件和路径=================");
        for (String filename : fileList) {
            System.out.println(filename);
        }
        // 使用listRoot（）静态方法列出所有的磁盘根路径
        File[] roots=File.listRoots();
        System.out.println("系统所有根路径=================");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
