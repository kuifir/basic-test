package reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Package: reflectTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 18:10
 * <p>
 * Version: 0.0.1
 */
public class CreateJFrame {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取JFrame对应的Class对象
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        // 获取JFrame中带一个字符串参数的构造器
        Constructor ctor = jframeClazz.getConstructor(String.class);
        // 调用Constructor 的newInstance方法创建对象
        Object obj = ctor.newInstance("测试窗口");
        // 输出JFrame对象
        System.out.println(obj);
    }
}
