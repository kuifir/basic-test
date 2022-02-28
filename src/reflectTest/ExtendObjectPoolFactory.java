package reflectTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
 * Date: Created in 2021/8/12 18:33
 * <p>
 * Version: 0.0.1
 */
public class ExtendObjectPoolFactory {
    // 定义一个对象池，前面是对象名，后面是实际对象
    private Map<String,Object> objectPool = new HashMap<>();
    private Properties config =new Properties();

    // 从指定属性文件中初始化Properties对象
    public void init(String fileName){
        try (FileInputStream fis =new FileInputStream("src//reflectTest//"+fileName);){
            config.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 定义一个创建对象的方法
    // 该方法只要传入一个字符串类名，程序可以根据该类名生成java对象
    private Object creatObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 根据字符串来获取对应的Class对象
        Class<?> clazz =Class.forName(clazzName);
        // 使用clazz对应类的默认构造器创建实例
        return clazz.newInstance();
    }

    // 该方法根据指定文件来初始化对象池
    // 它会根据配置文件来创建对象
    public void initPool() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (String name : config.stringPropertyNames()){
            // 每取出一个key-value对，如果key中不包含"%"
            // 这就表明是根据value来创建一个对象
            // 调用createObject 创建对象，并将对象添加到对象池中
            if(!name.contains("%")){
                objectPool.put(name,creatObject(config.getProperty(name)));
            }
        }
    }

    // 该方法会根据属性文件来调用指定对象的setter方法
    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String name : config.stringPropertyNames()){
            // 每取出一对key-value对，如果key中含有"%"
            // 即可认为该key用于控制调用对象的setter方法设置值
            // % 前半为对象名，后半控制setter方法名
            if(name.contains("%")){
                // 将配置文件中的key按"%"分割
                String[] objAndPrpo =name.split("%");
                // 取出调用setter方法的参数值
                Object target = getObject(objAndPrpo[0]);
                // 获取setter方法名：
                String mtdName = "set"+objAndPrpo[1].substring(0,1).toUpperCase()+ objAndPrpo[1].substring(1);
                // 通过target的getClassO（） 获取它的实现类对应的Class对象
                Class<?> targetClass = target.getClass();
                // 获取 希望调用的setter方法
                Method mtd = targetClass.getMethod(mtdName,String.class);
                // 通过Method的invoke 方法执行setter方法
                // 将config.getProperty(name)的值作为调用setter方法的参数
                mtd.invoke(target,config.getProperty(name));
            }
        }
    }

    private Object getObject(String name) {
        // 从objectPool中取出指定name对应的对象
        return objectPool.get(name);
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ExtendObjectPoolFactory epf =new ExtendObjectPoolFactory();
        epf.init("extObj.txt");
        epf.initPool();
        epf.initProperty();
        System.out.println(epf.getObject("a"));
    }
}
