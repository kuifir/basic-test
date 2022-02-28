package SystemTest;

/**
 * Package: SystemTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 17:08
 * <p>
 * Version: 0.0.1
 */
public class RuntimeTest {
    public static void main(String[] args) {
        // 获取java程序关联的运行时对象
        Runtime rt =Runtime.getRuntime();
        System.out.println("处理器数量："+rt.availableProcessors());
        System.out.println("空闲内存数："+rt.freeMemory());
        System.out.println("总内存数："+rt.totalMemory());
        System.out.println("可用最大内存数："+rt.maxMemory());
    }
}
