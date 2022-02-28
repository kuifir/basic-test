package CollectionTest.hashSetTest;

import java.util.HashSet;

/**
 * Package: CollectionTest
 * <p>
 * Description： hashSet通过equals()和hashCode()共同判断是否为同一对象
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 18:09
 * <p>
 * Version: 0.0.1
 */
public class HashsetTest {
    public static void main(String[] args) {
        HashSet books =new HashSet();
        // 分别向books对象中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());
        System.out.println(books);
    }
}
// 类A的equals（）方法总是返回true但是没有重写其hashCode方法
class A {
    public boolean equals(Object obj){
        return true;
    }
}
// 类B的hashCode（）方法总是返回1 但是没有重写其equals方法
class B {
    public int hashCode(){
        return 1;
    }
}
// 类C的hashCode（）方法总是返回2 equals（）方法总是返回true
class C {
    public int hashCode(){
        return 2;
    }
    public boolean equals(Object obj){
        return true;
    }
}
