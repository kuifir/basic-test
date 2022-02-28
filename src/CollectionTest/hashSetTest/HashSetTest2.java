package CollectionTest.hashSetTest;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Package: CollectionTest
 * <p>
 * Description： 重写hashCode和equals方法注意不能通过修改可变对象实例变量，导致产生相同对象
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 18:39
 * <p>
 * Version: 0.0.1
 */
public class HashSetTest2 {
    public static void main(String[] args) {
        HashSet<R> hs = new HashSet<>();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        // 打印HashSet集合，集合元素没有重复
        System.out.println(hs);
        //取出第一个元素
        Iterator<R> it = hs.iterator();
        R first = it.next();
        first.count = -3;
        // 再次输出 有重复元素
        System.out.println(hs);
        // 删除count为-3的R对象
        hs.remove(new R(-3));
        // 可以看待被删除了一个R元素
        System.out.println(hs);
        System.out.println("hs是否包含count为-3的R对象？ ： " + hs.contains(new R(-3))); // false
        System.out.println("hs是否包含count为-2的R对象？ ： " + hs.contains(new R(-2))); // false
    }
}
class R{
    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        R r = (R) o;
        return this.count == r.count;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}