package ThreadT.PoolT;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Package: ThreadT.PoolT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 15:33
 * <p>
 * Version: 0.0.1
 */
public class Sum {
    public static void main(String[] args) {
        int[] arr=new int[37];
        Random random=new Random();
        int total=0;
        for (int i=0,len=arr.length;i<len;i++){
            int a=random.nextInt(30);
            arr[i]=a;
            total+=a;
        }
        System.out.println(total);
        // 创建一个通用池
        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
        // 提交可分解的caltTask任务
        Future<Integer> ft= forkJoinPool.submit(new CalTask(arr,0,arr.length));
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        forkJoinPool.shutdown();
    }
}

// 继承RecursiveTask来实现"可分解"的任务
class CalTask extends RecursiveTask<Integer> {
    // 每个"小任务"最多打印的个数
    private static final int THRESHOLD = 5;
    private int[] arr;
    private int start;
    private int end;
    // 累加从start到end的数组元素
    public CalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        if(end-start<=THRESHOLD){
            for(int i=start;i<end;i++){
                sum+=arr[i];
            }
            return sum;
        }else {
            // 将大任务分解成小任务
            int middle=(start+end)/2;
            CalTask calTaskleft=new CalTask(arr,start,middle);
            CalTask CalTaskright=new CalTask(arr,middle,end);
            // 并行执行两个小任务
            calTaskleft.fork();
            CalTaskright.fork();
            // 把两个小任务累加结果合并起来
            sum=calTaskleft.join()+CalTaskright.join();
            return sum;
        }

    }
}