package reflectTest.Proxy.DynaProxy;

import java.lang.reflect.Proxy;

/**
 * Package: reflectTest.Proxy.DynaProxy
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 23:52
 * <p>
 * Version: 0.0.1
 */
public class MyProxyFactory {
    public static Object getProxy(Object target){
        // 创建一个MyInvocationHandler对象
        MyInvocationHandler handler =new MyInvocationHandler();
        // 为MyInvocationHandler 设置target对象
        handler.setTarget(target);
        //创建并返回一个动态代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }
}
