package CollectionTest;

import java.text.Collator;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * Package: CollectionTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 15:56
 * <p>
 * Version: 0.0.1
 */
public class CollectionEach {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<String>();
        books.add("Java");
        books.add("Android");
        books.forEach(System.out::println);
//        books.forEach(new Consumer <String>() {
//            @Override
//            public void accept(String s) {
//             System.out.println(s);
//            }
//        });

    }
}
