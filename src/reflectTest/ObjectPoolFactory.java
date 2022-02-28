package reflectTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Package: reflectTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 17:42
 * <p>
 * Version: 0.0.1
 */
public class ObjectPoolFactory {
    // 定义一个对象池，前面是对象名，后面是实际对象
    private Map<String,Object> objectpool = new HashMap<>();
    // 定义一个创建对象的方法
    // 该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);
        // 使用clazz对应类的默认构造器创建实例
        return clazz.newInstance();

    }
    // 该方法根据指定文件来初始化对象池
    // 它会根据配置文件来创建对象
    public void initPool(String fileName) throws  IllegalAccessException, InstantiationException, ClassNotFoundException {
        try (FileInputStream fis =new FileInputStream("src//reflectTest//"+fileName);)
        {
            Properties props =new Properties();
            props.load(fis);
            for (String name : props.stringPropertyNames()){
                // 没取出一对key-value对，就根据value创建一个对象
                // 调用createObject()创建对象，并将对象添加到对象池中
                objectpool.put(name,createObject(props.getProperty(name)));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取"+fileName +"异常");
        }
    }
    public Object getObject(String name){
        // 从objectpool中取出指定name对应的对象
        return objectpool.get(name);
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ObjectPoolFactory pf =new ObjectPoolFactory();
        pf.initPool("obj.txt");
        System.out.println(pf.getObject("a"));
        System.out.println(pf.getObject("b"));
    }
}
