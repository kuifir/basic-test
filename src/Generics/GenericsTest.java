package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: Generics
 * <p>
 * Description： TODO 泛型派生子类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 9:32
 * <p>
 * Version: 0.0.1
 */
public class GenericsTest {
    public void test(List<Object> a){
        for (int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 不管泛型的实际类型是什么，在运行时总有同样的类
        System.out.println(list.getClass()==list2.getClass());
        //List<String> 不是List<Object> 的子类
        list.add("aaaa");
        GenericsTest genericsTest=new GenericsTest();
        //        Error:(31, 27) java: 不兼容的类型: java.util.List<java.lang.String>无法转换为java.util.List<java.lang.Object>
        // genericsTest.test(list);
    }
}

class Apple<T> {
    private T info;

    public Apple() {

    }

    public Apple(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        Apple<String> apple1 = new Apple<>("aaaa");
        Apple<Double> apple2 = new Apple<>(2.333332);
        System.out.println(apple1.getInfo());
        System.out.println(apple2.getInfo());
    }
}

/**
 * 如果从Apple<String> 派生子类，那么所有的T都替换成String
 */
class A extends Apple<String> {
    //    public String getinfo(){
//        return "子类"+super.getInfo();
//    }

    //    Generics.A中的getInfo()无法覆盖Generics.Apple中的getInfo()
//  返回类型java.lang.Object与java.lang.String不兼容
//    public Object getInfo(){
//        return "子类";
//    }
    public static void main(String[] args) {
        A a = new A();
//        a.setInfo("aaa");
        System.out.println(a.getInfo());
    }
}

/**
 * 如果没有传入实际类型参数，T类型为Object
 */
class A2 extends Apple {
    public String getInfo() {
//        Error:(61, 29) java: 不兼容的类型: java.lang.Object无法转换为java.lang.String
//        return super.getInfo();
        return super.getInfo().toString();
    }

    public static void main(String[] args) {
        A2 a2 = new A2();
        a2.setInfo("aaa");
        System.out.println(a2.getInfo());
    }
}

class B extends Apple {
    public static void main(String[] args) {
        B b = new B();
        b.setInfo("aaa");
        System.out.println(b.getInfo());
    }
}