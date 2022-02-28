package ThreadT.start;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Package: ThreadT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 17:00
 * <p>
 * Version: 0.0.1
 */
public class CallableTest {
    public static void main(String[] args) {
        //CallableTest ct = new CallableTest();
    /*    FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int i = 0;
                for (; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "=====>" + i);
                }
                return i;
            }
        });*/
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            if (i == 20) {
                Thread thread =new Thread(task, "有返回值的线程");
                thread.start();
                Thread thread2 =new Thread(task, "有返回值的线程2");
                thread2.start();
                System.out.println("线程是否启动"+thread2.isAlive());

            }
        }
        try {
            // 会阻塞
            System.out.println("返回值" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
