package CollectionTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * Package: CollectionTest
 * <p>
 * Description： 通过Predicate来简化集合运算
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 16:41
 * <p>
 * Version: 0.0.1
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<>();
        books.add(new String("Java"));
        books.add(new String("Android"));
        books.add(new String("Ajax"));
        books.add(new String("ios"));
        System.out.println(calAll(books,p-> p.length()<5));
    }
    public static int calAll(Collection<String> books, Predicate<? super String> p){
        int total = 0;
        for (String book: books) {
            if (p.test(book)) total++;
        }
        return total;
    }
}
