package CollectionTest.TreeSetTest;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Package: CollectionTest.TreeSetTest
 * <p>
 * Description： 实现定制排序，创建在TreeSet集合对象时，提供一个Comparator对象与该TreeSet关联
 * 由该Comparator对象负责集合元素的排序逻辑。
 * Comparator是一个函数式接口，因此可以用Lambda表达式来代替Comparator对象
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/19 0:17
 * <p>
 * Version: 0.0.1
 */
public class TreeSetTest4 {
    public static void main(String[] args) {
//        TreeSet<M> ls = new TreeSet<M>(new Comparator<M>() {
//            @Override
//            public int compare(M o1, M o2) {
//                // 返回正数表明o1大于o2
//                return o1.age > o2.age ? 1 : o1.age < o2.age ? -1 : 0;
//            }
//        });
//        TreeSet<M> ls = new TreeSet<>((o1, o2) -> o1.age > o2.age ? 1 : o1.age < o2.age ? -1 : 0);
//        TreeSet<M> ls = new TreeSet<>((o1, o2) -> Integer.compare(o1.age, o2.age));
        TreeSet<M> ls = new TreeSet<>(Comparator.comparingInt(o -> o.age));
        ls.add(new M(5));
        ls.add(new M(-3));
        ls.add(new M(9));
        System.out.println(ls);
    }
}

class M {
    int age;

    public M(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "M{" +
                "age=" + age +
                '}';
    }
}