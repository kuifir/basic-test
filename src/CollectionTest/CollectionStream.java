package CollectionTest;

import java.util.Collection;
import java.util.HashSet;

/**
 * Package: CollectionTest
 * <p>
 * Description： java8 允许使用流式API来造作集合，
 * Collection接口提供了一个stream（）默认方法返回集合对应流
 * 可通过流式API操作集合元素，由于Stream可以对集合元素进行整体的聚集操作，可极大丰富集合功能
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 17:18
 * <p>
 * Version: 0.0.1
 */
public class CollectionStream {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<>();
        books.add(new String("Java"));
        books.add(new String("Android"));
        books.add(new String("Ajax"));
        books.add(new String("ios"));
        System.out.println(books.stream().
                filter(p->p.contains("a")).count());
        System.out.println(books.stream().
                filter(p->p.length()<5).count());
        // 先调用Collection对象的stream()方法将集合转换为Stream
        // 在调用Stream的mapToInt()方法获取原有的Stream对应的IntStream
        books.stream().forEach(System.out::print);
        books.stream().mapToInt(ele -> ele.length()).forEach(System.out::print);
    }
}
