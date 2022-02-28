package IOTest.NIO2.PathTest;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Package: IOTest.NIO2.PathTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 19:08
 * <p>
 * Version: 0.0.1
 */
public class PathTest {
    public static void main(String[] args) {
        // 以当前路径来创建Path对象
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量:"+path.getNameCount());
        System.out.println("path的根路径"+path.getRoot());
        // 获取path对应的绝对路径
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        // 获取绝对路径的跟路径
        System.out.println("absolutePath的根路径"+absolutePath.getRoot());
        // 获取绝对路径所包含的路径数量
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(1));
        // 以多个String来构建path对象
        Path path2 =Paths.get("G:","publish","codes");
        System.out.println(path2);
    }
}
