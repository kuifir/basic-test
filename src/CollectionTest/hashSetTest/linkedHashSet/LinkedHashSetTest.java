package CollectionTest.hashSetTest.linkedHashSet;

import java.util.LinkedHashSet;

/**
 * Package: CollectionTest.hashSetTest.linkedHashSet
 * <p>
 * Description： hashSet有个子类LinkedHashSet,
 * 也是根据元素的hashCode值来决定元素的存储位置，
 * 但他同时使用链表维护元素的次序，这样使元素看起来是以插入的顺序保存的
 * 遍历LinkedHashSet集合里的元素是，LinkedHashSet会按照添加顺序来访问集合元素
 * LinkedHashSet需要维护元素的插入顺序，因此性能略低于HashSet，
 * 但在迭代访问Set里的全部元素时将有很好的性能，因为他以链表来维护内部顺序
 * ===虽然使用链表记录集合元素的添加顺序，但仍然是HashSet，不允许集合元素重复
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 22:50
 * <p>
 * Version: 0.0.1
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> books =new LinkedHashSet<>();
        books.add("Java");
        books.add("Ajax");
        books.add("Android");
        System.out.println(books);
        // 删除在添加，查看输出顺序
        books.remove("Java");
        books.add("Java");
        System.out.println(books);
    }
}
