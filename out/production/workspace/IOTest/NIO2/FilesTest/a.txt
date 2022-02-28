package IOTest.NIO2.FilesTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Package: IOTest.NIO2.FilesTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 19:21
 * <p>
 * Version: 0.0.1
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        Path path =Paths.get("src\\IOTest\\NIO2\\FilesTest\\FilesTest.java");
        // 复制文件
        Files.copy(path,new FileOutputStream("src\\IOTest\\NIO2\\FilesTest\\a.txt"));
        // 判断FilesTest.java是否为隐藏文件
        System.out.println("FilesTest.java是否为隐藏文件"+Files.isHidden(path));
        // 一次性读取FilesTest.java的所有行
        List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
        System.out.println(lines);
        // 判断指定文件大小
        System.out.println("FilesTest.java文件的大小为"+Files.size(path));
        List<String> poem =new ArrayList<>();
        poem.add("水晶潭底银鱼跃");
        poem.add("清徐风中碧竿横");
        // 直接将多个字符串内容写入指定文件中
        Files.write(Paths.get("src\\IOTest\\NIO2\\FilesTest\\pome.txt"),poem,Charset.forName("UTF-8"));
        // 使用Java8新增的Stream API列出当前目录下所有文件和子目录
        Files.list(Paths.get(".")).forEach(path1-> System.out.println(path1));
        // 使用Java8 新增的Stream API读取文件内容
        Files.lines(path,Charset.forName("UTF-8")).forEach(System.out::println);
        FileStore cStore = Files.getFileStore(Paths.get("G:"));
        // 判断G盘的总空间可用空间
        System.out.println("G:共有空间:"+cStore.getTotalSpace());
        System.out.println("G:可用空间"+cStore.getUsableSpace());
    }
}

