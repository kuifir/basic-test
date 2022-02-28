package ThreadT.PoolT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package: ThreadT.PoolT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 14:48
 * <p>
 * Version: 0.0.1
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService es= Executors.newFixedThreadPool(6);
        Runnable target=()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"-----"+i);
            }
        };
        es.submit(target);
        es.submit(target);
        es.shutdown();
    }
}
