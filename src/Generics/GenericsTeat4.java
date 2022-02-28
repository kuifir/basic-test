package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: Generics
 * <p>
 * Description： TODO 泛型擦除
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 17:44
 * <p>
 * Version: 0.0.1
 */
public class GenericsTeat4 {
    public static void main(String[] args) {
        Apple2<Integer> a = new Apple2<>(6);
        // a的getSize返回Integer类型对象
        Integer as =a.getSize();
        // 把a对象给Apple2变量；丢失尖括号里的类型信息
        Apple2 b = a;
        // b只知道size的类型是Number
        Number size2 =b.getSize();
        // 下面代码将会引起编译错误
//        Integer size3 = b.getSize();

        //对泛型而言，可以直接把一个List对象赋给一个List<String>对象
        List<Integer> li =new ArrayList<>();
        li.add(6);
        li.add(7);
        List lsit =li;
        // 下面代码引起“未经检查的转换”警号，编译运行时完全正常
        List<String> ls =lsit;
//        但只要访问ls的元素，如下面代码将引起运行时异常
        System.out.println(ls.get(0));
    }
}
class Apple2 <T extends Number>{
    T size;

    public Apple2() {
    }

    public Apple2(T size) {
        this.size = size;
    }

    public T getSize() {
        return size;
    }

    public void setSize(T size) {
        this.size = size;
    }
}