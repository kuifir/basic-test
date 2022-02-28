package ThreadT;

/**
 * Package: ThreadT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 14:04
 * <p>
 * Version: 0.0.1
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字："+mainGroup.getName());
        System.out.println("主线程组是否后台线程组："+mainGroup.isDaemon());
        new MyThread("线程1----").start();
        ThreadGroup threadGroup=new ThreadGroup("新线程组");
        threadGroup.setDaemon(true);
        System.out.println("新线程组是否后台线程组："+threadGroup.isDaemon());
        new MyThread(threadGroup,"线程2--").start();
        new MyThread(threadGroup,"线程3--").start();
        System.out.println("新线程组线程数目："+threadGroup.activeCount());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + i);
        }
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }
}