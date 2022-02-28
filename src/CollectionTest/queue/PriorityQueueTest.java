package CollectionTest.queue;

import java.util.PriorityQueue;

/**
 * Package: CollectionTest.queue
 * <p>
 * Description： PriorityQueue保存队列的顺序不是按加入队列的顺序，而是按队列元素的大小进行重新排序
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/19 15:32
 * <p>
 * Version: 0.0.1
 */
public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq =new PriorityQueue<>();
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        System.out.println(pq);//不按顺序是因为toString的原因
        System.out.println(pq.poll());
    }
}
