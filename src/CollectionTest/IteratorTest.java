package CollectionTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Package: CollectionTest
 * <p>
 * Description： Iterator必须依附于collection对象，
 * 当使用Iterator迭代collection集合元素是，collection集合里的元素不可改变
 * 只有通过Iterator的remove（）方法删除上一次next方法返回的集合元素才可以
 * 否则将引发java.util.ConcurrentModificationException
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 16:04
 * <p>
 * Version: 0.0.1
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<String>();
        books.add("Java");
        books.add("Android");
        // 获取books集合对应的迭代器
        Iterator<String> iterator =books.iterator();
        while (iterator.hasNext()){
            String book =iterator.next();
            System.out.println(book);
            if (book.equals("Java")) {
                // 使用Iterator迭代过程中，不可修改集合元素，下面引发异常
//                books.remove(book);
//                books.remove("Java");
                // 从集合删除上一次next()方法返回的元素
//                iterator.remove();
            }
            // 对book赋值，不会改变集合元素本身
            book ="测试";
        }
        System.out.println(books);
    }
}
