package classLoadTest;

import sun.misc.Launcher;

import java.net.URI;
import java.net.URL;

/**
 * Package: classLoadTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 16:48
 * <p>
 * Version: 0.0.1
 */
public class BootstrapTest {
    public static void main(String[] args) {
        // 获取根类加载器所加载的全部URL数组
        URL[] uris = Launcher.getBootstrapClassPath().getURLs();
        // 遍历、输出跟类加载器加载的全部URL
        for(int i = 0; i < uris.length;i++){
            System.out.println(uris[i].toExternalForm());
        }
    }
}
