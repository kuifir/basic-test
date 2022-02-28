package ThreadT.ThreadContro;

/**
 * Package: ThreadT
 * <p>
 * Description： TODO
 * <p>
 * Author: 一个线程让另一个线程等待的方法join()方法。
 * 当在某个程序执行流中调用其他线程的join()方法时，
 * 调用线程将被阻塞，直到被jion()方法加入的join线程执行完为止
 * join通常由使用线程的程序调用，以将大问题划分成许多小问题，每个小问题分配一个线程，当所有的小问题都得到处理后，在调用主线程来进一步操作
 * <p>
 * Date: Created in 2020/7/29 17:47
 * <p>
 * Version: 0.0.1
 */
public class JoinThread extends Thread {
    // 提供一个有参构造器，用于设置该线程的名字
    public JoinThread(String name) {
        super(name);
    }

    // 重写run()方法，定义线程执行体
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "=====>" + i);
        }
    }

    public static void main(String[] args) {
        // 启用子线程
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {

            if (i == 20) {
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();
                try {
                    // main线程调用了jt线程的join()方法，main线程必须等jt执行结束才会向下执行
                    jt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
