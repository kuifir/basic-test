package ThreadT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Package: ThreadT
 * <p>
 * Description：阻塞队列
 * BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
 * try {
 *             bq.put("java");
 *             bq.put("java");
 *             bq.put("java");
 *         } catch (InterruptedException e) {
 *             e.printStackTrace();
 *         }TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 13:28
 * <p>
 * Version: 0.0.1
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        new Consumer(bq).start();
    }
}

class Producer extends Thread {
    private BlockingQueue<String> bq;

    @Override
    public void run() {
       String[] str=new String[]{
               "Java","Spring","mybatis"
       };
       for (int i=0;i<10;i++){

           System.out.println(getName()+"---------生产第"+i+"个");
           try {
               Thread.sleep(200);
               bq.put(str[i%3]);

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(getName()+"生产完成第"+i+"个"+bq);
       }
    }

    public Producer(BlockingQueue<String> bq) {
        this.bq = bq;
    }
}
class Consumer extends Thread {
    private BlockingQueue<String> bq;

    @Override
    public void run() {
        int i= 0;
        while(true){
            System.out.println(getName()+"=========消费");
            try {
                Thread.sleep(200);
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"=======消费完成第"+ ++i +"个"+bq);

        }

    }
    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }
}