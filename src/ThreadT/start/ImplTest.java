package ThreadT.start;

/**
 * Package: ThreadT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 16:23
 * <p>
 * Version: 0.0.1
 */
public class ImplTest implements Runnable {

    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            // 当线程类实现Runnable接口时
            // 如果想获取当前线程，只能用Thread.currentThread()方法
            System.out.println(Thread.currentThread().getName() + "=====>" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            if (i == 20) {
                ImplTest it = new ImplTest();
                // 多个线程共享一个target，所以共享实例变量
                // ew Thread(target, name)创建新线程
                new Thread(it, "线程1").start();
                new Thread(it, "线程2").start();
                new Thread(it, "线程3").start();
            }
        }
    }
}
