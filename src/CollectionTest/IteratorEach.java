package CollectionTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Package: CollectionTest
 * <p>
 * Description： Lamada遍历Iterator
 * java 8 新增了forEachRemaining(Consumer action) 方法 Consumer也是函数式接口
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 16:23
 * <p>
 * Version: 0.0.1
 */
public class IteratorEach {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<String>();
        books.add("Java");
        books.add("Android");
        // 获取books对应的迭代器
        Iterator<String> iterator = books.iterator();
        iterator.forEachRemaining(System.out::println);
//        iterator.forEachRemaining(s -> System.out.println(s));
//        iterator.forEachRemaining(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
    }
}
