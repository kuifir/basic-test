package CollectionTest.TreeSetTest;

import java.util.Date;
import java.util.TreeSet;

/**
 * Package: CollectionTest.TreeSetTest
 * <p>
 * Description： 如果试图将一个对象放入TreeSet中，则该对象必须实现Comparable接口，否则程序抛出异常
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 23:36
 * <p>
 * Version: 0.0.1
 */
public class TreeSetErrorTest {
    public static void main(String[] args) {
        TreeSet<Err> ts = new TreeSet<>();
        // 向TreeSet集合中添加两个Err对象
        // 添加第一个元素时，TreeSet里没有任何元素，所以不会有问题（但是本人实验第一个添加就报错了）
        // 添加第二个Err对象时，TreeSet就会调用该对象的compareTo（Object obj）方法与集合其他元素进行比较
//        ts.add(new Err());
//        ts.add(new Err());
        // TreeSet添加的应该是同一个类的对象
        TreeSet ts2 = new TreeSet<>();
        ts2.add(new String("Java"));
        ts2.add(new Date());

    }
}
class Err{ }