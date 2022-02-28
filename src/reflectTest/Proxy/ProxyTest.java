package reflectTest.Proxy;

import java.lang.reflect.*;

/**
 * Package: reflectTest
 * <p>
 * Description： Proxy提供了用于创建动态代类和代理对象的静态方法
 * getProxyClass
 * newProxyInstance
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 23:14
 * <p>
 * Version: 0.0.1
 */
interface People {
    void walk();

    void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler {

    /*执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
     * 其中：
     * proxy:代表动态代理的对象
     * method: 代表正在执行的方法
     * args：代表调用目标方法时的传参
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法：" + method + "==================");
        if (args != null) {
            System.out.println("下面是执行该方法传入的实参");
            for (Object arg : args) {
                System.out.println(arg);
            }
        }else {
            System.out.println("调用该方法没有实参");
        }
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 创建一个InvocationHandler对象
        InvocationHandler handler =new MyInvokationHandler();
        // 使用指定的InvovatonHandler来生成一个动态代理对象
        People people = (People) Proxy.newProxyInstance(People.class.getClassLoader(),new Class[]{People.class},handler);
//        Class proxyClazz = Proxy.getProxyClass(People.class.getClassLoader(),new Class[]{People.class});
//        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
//        People people = (People) constructor.newInstance(handler);
        people.walk();
        people.sayHello("孙悟空");
    }
}
