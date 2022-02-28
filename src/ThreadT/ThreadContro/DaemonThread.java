package ThreadT.ThreadContro;

/**
 * Package: ThreadT
 * <p>
 * Description： 后台线程
 * 有一种线程他是在后台运行的，他的任务是为其他线程提供服务，这种线程被称为后台线程
 * JVM的垃圾回收线程就是典型的后台线程
 * 后台线程有个特征：如果所有的前台线程都死亡，后台线程会自动死亡
 * 调用Thread对象的setDaemon(true)方法可将指定线程设置成后台线程
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 18:03
 * <p>
 * Version: 0.0.1
 */
public class DaemonThread extends Thread {
    // 定义后台线程执行体和普通线程没有任何区别
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + "=====>" + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        // 将此线程设置成后台线程，
        // 必须在线程运行前调用，否则会引发IllegalThreadStateException
        dt.setDaemon(true);
        //dt.setPriority(Thread.MAX_PRIORITY);//设置优先级
        // 启动后台线程
        dt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            //测试下sleep方法，在sleep()之后不在乎优先级，其他所有的线程都有可能运行
           /* try {
                Thread.sleep(1000);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //测试下yield方法,yield()暂停当前线程，系统重新调度，有可能继续执行。
            //yield()只会给优先级更高或相同的机会。
//            Thread.yield();
//            System.out.println(new Date());
        }
    }
}
