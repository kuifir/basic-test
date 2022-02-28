package reflectTest.Proxy.DynaProxy;

/**
 * Package: reflectTest.Proxy.DynaProxy
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 23:40
 * <p>
 * Version: 0.0.1
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("一只猎狗");
    }

    @Override
    public void run() {
        System.out.println("迅速奔跑");
    }
}
