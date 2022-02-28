package ThreadT.ThreadContro;

/**
 * Package: ThreadT.ThreadContro
 * <p>
 * Description： yield也是Thread的一个静态方法，
 * 它可以让当前正在执行的线程暂停，但他不会阻塞该线程，他只是将该线程转入就绪状态。
 * yield只是让当前线程停一下，让系统的线程调度器重新调度一次，
 * 完全可能的情况是：当某个线程调用的yield()方法暂停之后，线程调度器又将其调度出来重新执行
 * 实际上，当某个线程调用了yield()方法暂停之后，
 * 只有优先级与当前线程相同，或者优先级比当前线程更高的处于就绪状态的线程才会获得执行的机会
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 16:58
 * <p>
 * Version: 0.0.1
 */
public class YieldTest implements Runnable{
    // 定义run方法作为线程执行体
    @Override
    public void run() {
        for (int i =0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"========>"+i);
            // 当i=20时，使用yield()让当前线程让步
            if(i ==20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest target = new YieldTest();
        YieldTest target2 = new YieldTest();
        // 启动两个并发线程
        // 设置不同优先级的话，使用yield()之后执行优先级高的
        // 使用sleep()的话，会执行可以执行的线程，不管优先级是否不当前低
        Thread thread =new Thread(target,"高级");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        Thread thread2 =new Thread(target2,"低级");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
}
