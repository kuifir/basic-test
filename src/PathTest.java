import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 13:28
 * <p>
 * Version: 0.0.1
 */
public class PathTest {
    public static void main(String[] args) {
        Path path= Paths.get(".");
        System.out.println("path里包含的路径数量"+path.getNameCount());
        System.out.println("path的根路径"+path.getRoot());
        //path对应绝对路径
        Path absolutePath=path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println("绝对路径的根路径"+absolutePath.getRoot());
        //获取绝对路径的路径数量
        System.out.println("绝对路径包含的路径数量"+absolutePath.getNameCount());
        System.out.println(absolutePath.getName(2));
        Path path2=Paths.get("g:","code","workspace");
        System.out.println(path2);

    }
}
