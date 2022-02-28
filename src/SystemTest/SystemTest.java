package SystemTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Package: SystemTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 16:32
 * <p>
 * Version: 0.0.1
 */
public class SystemTest {
    public static void main(String[] args) throws IOException {
        // 获取系统所有的环境变量
        Map<String,String> env = System.getenv();
        for(String name : env.keySet()){
            System.out.println(name + "---------->" + env.get(name));
        }
        // 获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        // 获取所有的系统属性
        Properties properties = System.getProperties();
        // 将所有的系统属性保存到prpos.txt中
        properties.store(new FileOutputStream("prpos.txt"),"System Properties");
        // 输出特定的系统属性
        System.out.println(System.getProperty("os.name"));
    }
}
