package reflectTest.Proxy.DynaProxy;

/**
 * Package: reflectTest.Proxy.DynaProxy
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 23:58
 * <p>
 * Version: 0.0.1
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个原始的Gundog对象，作为target
        Dog tatget =new GunDog();
        // 以指定的target 来创建动态代理对象
        Dog dog = (Dog) MyProxyFactory.getProxy(tatget);
        dog.info();
        dog.run();
    }
}
