package ThreadT.start;

/**
 * Package: ThreadT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 16:13
 * <p>
 * Version: 0.0.1
 */
public class ExtendTest extends Thread {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            // 当线程类继承Tread类时，直接使用this即可获取当前线程
            // Thread对象的getName()返回当前线程的名字
            // 因此可以直接调用getName()返回当前线程的名字
            System.out.println(getName() + "=====>" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // 调用Thread的CurrentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            if (i==20){
                // 创建并启动第一个线程
                new ExtendTest().start();
                // 创建并启动第二个线程
                new ExtendTest().start();
            }
        }
    }
}
