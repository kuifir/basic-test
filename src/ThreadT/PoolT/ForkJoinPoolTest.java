package ThreadT.PoolT;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Package: ThreadT.PoolT
 * <p>
 * Description： ForkJoinPool
 * Java7提供了ForkJoinPool来支持将一个任务拆分为多个"小任务"进行并行计算，
 * 再把多个"小任务"的结果合并成总的计算结果
 * ForkJoinPool是ExecutorService的实现类，因此是一种特殊的线程池
 *
 * Java8进一步拓展了ForkJoinPool的功能，Java8 为 ForkJoinPool增加了通用池功能
 * ForkJoinPool类通过两个静态方法提供通用池功能
 *
 * 创建了ForkJoinPool实例之后，就可以调用ForkJoinPool的submit(ForkJoinTask task)或
 * invoke(ForkJoinTask task)方法来执行任务了。
 * 其中ForkJoinTask代表一个可并行、合并的任务。
 * ForkJoinTask是一个抽象类，它还有两个抽象子类，RecursiveAction和RecursiveTask.
 * 其中RecursiveTask代表有返回值的任务，RecursiveAction代表没有返回值的任务
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 15:06
 * <p>
 * Version: 0.0.1
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        PrintTask printTask=new PrintTask(0,300);
        // 提交可分解的PrintTask任务
        pool.submit(printTask);
        try {
            pool.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

}

// 继承RecursiveAction来实现可分解的任务
class PrintTask extends RecursiveAction {

    // 每个小打印最多打印的个数
    private static final int THRESHOLD=50;
    private int start;
    private int end;
    // 打印从start到end的任务
    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end和start之间的查小于THRESHOLD时，开始打印
        if(end-start<THRESHOLD){
            for (int i=start;i<end;i++){
             System.out.println(Thread.currentThread().getName()+"==="+i);
            }
        }else {
            // 当end和start之间的差大于THRESHOLD时
            // 将大任务分解成两个任务
            int middle=(start+end)/2;
            PrintTask left=new PrintTask(start,middle);
            PrintTask right=new PrintTask(middle,end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}