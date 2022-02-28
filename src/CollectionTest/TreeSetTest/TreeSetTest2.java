package CollectionTest.TreeSetTest;

import java.util.Objects;
import java.util.TreeSet;

/**
 * Package: CollectionTest.TreeSetTest
 * <p>
 * Description： TreeSet判断两个对象是否相等的唯一标准时：两个对象通过compareTo（Oject obj）方法比较是否返回0
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/19 0:02
 * <p>
 * Version: 0.0.1
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        TreeSet<Z> set =new TreeSet<>();
        Z z1 =new Z(6);
        set.add(z1);
        //第二次添加同一对象，输出true,表明添加成功
        System.out.println(set.add(z1));
        // 下面输出Set集合，将输出两个元素
        System.out.println(set);
        // 修改Set集合的第一个元素的age变量
        set.first().age=9;
        // 输出set集合的最后一个age变量，将看到也变成了9
        System.out.println(set.last().age);
    }
}
class Z implements Comparable{
    int age;

    public Z(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }


    @Override
    public int compareTo(Object o) {
        return 1;
    }

    @Override
    public String toString() {
        return "Z{" +
                "age=" + age +
                '}';
    }
}
