package CollectionTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * Package: CollectionTest
 * <p>
 * Description： java 8为collection集合新增了一个removeif(Predicate filter)方法
 * 该方法会批量删除符合fileter条件的所有元素。
 * 参数Predicate也是函数式接口，可用lambda表达式作为参数
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 16:29
 * <p>
 * Version: 0.0.1
 */
public class PredicateTest {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<>();
        books.add(new String("Java"));
        books.add(new String("Android"));
        books.add(new String("Ajax"));
        books.add(new String("ios"));
        books.removeIf(s -> s.length()<5);
//        books.removeIf(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length()<5;
//            }
//        });
        System.out.println(books);
    }
}
