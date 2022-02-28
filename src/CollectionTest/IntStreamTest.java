package CollectionTest;

import java.util.stream.IntStream;

/**
 * Package: CollectionTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 16:58
 * <p>
 * Version: 0.0.1
 */
public class IntStreamTest {
    public static void main(String[] args) {
        IntStream is = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        // 下面调用聚集方法的代码每次只能执行一行
//        System.out.println("is所有元素的最大值："+is.max().getAsInt());
//        System.out.println("is所有元素的最小值："+is.min().getAsInt());
//        System.out.println("is所有元素的总和："+is.sum());
//        System.out.println("is所有元素的总数："+is.count());
//        System.out.println("is所有元素的平均值："+is.average());
//        System.out.println("is所有元素的平方是否都大于20："+is.allMatch(p->p*p >20));
//        System.out.println("is所有元素的平方是否有大于20的元素："+is.anyMatch(p->p*p >20));
        // 将is映射成一个新stream，新stream的每个元素是原steam元素的2倍+1
        IntStream newis = is.map(p->p*2+1);
        newis.forEach(System.out::println);
    }
}
