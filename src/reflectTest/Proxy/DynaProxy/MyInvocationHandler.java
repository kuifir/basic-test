package reflectTest.Proxy.DynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Package: reflectTest.Proxy.DynaProxy
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 23:44
 * <p>
 * Version: 0.0.1
 */
public class MyInvocationHandler implements InvocationHandler {
    // 需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 执行动态代理对象的所有方法时，都会被替代成执行如下的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du =new DogUtil();
        // 执行第一个工具方法
        du.method1();
        //以target作为主调来执行method方法
        Object result = method.invoke(target,args);
        // 执行第二个工具方法
        du.method2();
        return result;
    }
}
