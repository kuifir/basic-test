package CollectionTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Package: CollectionTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 15:39
 * <p>
 * Version: 0.0.1
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection c =new ArrayList();
        // 添加元素
        c.add("孙悟空");
        // 虽然集合不能放基本类型的值，但Java支持集中装箱
        c.add(6);
        System.out.println("c集合的元素个数为："+c.size());
        //删除指定元素
        c.remove(6);
        System.out.println("c集合的元素个数为："+c.size());
        System.out.println("c集合是否包含字符串'孙悟空：'"+c.contains("孙悟空"));
        c.add("java");
        System.out.println(c);
        Collection books =new HashSet();
        books.add("java");
        books.add("bbbb");
        System.out.println("c集合是否包含books集合"+c.containsAll(books));
        c.removeAll(books);
        System.out.println(c);
        // 删除c集合里的所有元素
        c.clear();
        System.out.println(c);
        books.retainAll(c);
        System.out.println(books);
    }
}
