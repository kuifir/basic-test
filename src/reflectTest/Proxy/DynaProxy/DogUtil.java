package reflectTest.Proxy.DynaProxy;

/**
 * Package: reflectTest.Proxy.DynaProxy
 * <p>
 * Description： 假设是提取的公共方法
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 23:42
 * <p>
 * Version: 0.0.1
 */
public class DogUtil {
    // 第一个拦截方法
    public void method1(){
        System.out.println("模拟第一个通用方法");
    }
    // 第二个拦截方法
    public void method2(){
        System.out.println("模拟第二个通用方法");
    }
}
