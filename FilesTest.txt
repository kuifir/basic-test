import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 13:40
 * <p>
 * Version: 0.0.1
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        //复制文件
        Files.copy(Paths.get("src\\FilesTest.java"), new FileOutputStream("FilesTest.txt"));
        System.out.println("判断是否为隐藏文件" + Files.isHidden(Paths.get("src\\FilesTest.java")));
        //一次性读取文件所有行
        List<String> lines = Files.readAllLines(Paths.get("src\\FilesTest.java"), StandardCharsets.UTF_8);
        System.out.println(lines);
        System.out.println("文件大小为" + Files.size(Paths.get("src\\FilesTest.java")));
        List<String> list=new ArrayList<>();
        list.add("看到覅哦嗯");
        list.add("2看到覅哦嗯");
        list.add("3看到覅哦嗯");
        Files.write(Paths.get("pom.txt"),list,StandardCharsets.UTF_8);
        //列出所有子文件子目录
        Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
        //去读文件内容
        Files.lines(Paths.get("src\\FilesTest.java"),StandardCharsets.UTF_8)
                .forEach(line-> System.out.println(line));
        FileStore cStore =Files.getFileStore(Paths.get("C:"));
        System.out.println("C:共有空间"+cStore.getTotalSpace());
        System.out.println("C:可用空间"+cStore.getUsableSpace());
    }
}
