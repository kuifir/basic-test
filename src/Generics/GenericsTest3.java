package Generics;

/**
 * Package: Generics
 * <p>
 * Description： TODO java1.8对泛型推断增加强
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 17:18
 * <p>
 * Version: 0.0.1
 */
public class GenericsTest3 {
    public static void main(String[] args) {
        // 可以通过方法赋值的目标参数来推断类型参数为String
        MyUtil<String> ls = MyUtil.nil();
        // 无需使用下面语句在调用nil()方法时指定类型参数的类型
        MyUtil<String> mu = MyUtil.<String> nil();
        // 可调用cons()方法所需的参数类型来推断参数类型为Interger
        MyUtil.cons(42,MyUtil.nil());
        // 无需使用下面语句再调用nil()方法时指定类型参数的类型
        MyUtil.cons(42,MyUtil.<Integer>nil());
        // 希望系统能给推断出nil()方法时类型参数为Sting类型
        // 但实际上Java8依然推断不出来，所以下面代码报错
//        String s = MyUtil.nil().head();
        // 因此上面参数必须显示指定类型参数，即将代码改为如下形式
        String s = MyUtil.<String>nil().head();
    }
}
class MyUtil<E>{
    public static <Z> MyUtil<Z> nil(){
        return null;
    }
    public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail){
        return null;
    }
    E head(){
        return null;
    }
}
