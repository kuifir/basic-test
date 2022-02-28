package classLoadTest;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Package: classLoadTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 17:07
 * <p>
 * Version: 0.0.1
 */
public class ClassLoaderPrpoTest {
    public static void main(String[] args) throws IOException {
        // 获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器"+systemLoader);
        /*获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定
        * 如果操作系统没有指定CALSSPATH环境变量，则默认当前路径作为系统类加载器的加载路径
        * */
        Enumeration<URL> em1 =systemLoader.getResources("");
        while (em1.hasMoreElements()){
            System.out.println(em1.nextElement());
        }
        // 获取系统类加载器的父类加载器，得到拓展类加载器
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println("拓展类加载器："+extensionLader);
        System.out.println("拓展类加载器的路径：" +System.getProperty("java.ext.dirs"));
        System.out.println("拓展类加载器的parent"+extensionLader.getParent());
    }
}
