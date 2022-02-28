package lambda;

import javax.swing.*;

/**
 * Package: lambda
 * <p>
 * Description： TODO 方法引用和构造器引用
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/9 11:22
 * <p>
 * Version: 0.0.1
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        //=============================================================================
        Converter converter1 = from -> Integer.valueOf(from);
        Integer val =converter1.convert("99");
        System.out.println(val);

        // 引用类方法
        // 函数式接口中被实现的方法的全部参数传给该类方法作为参数
        Converter converter2 = Integer::valueOf;
        Integer val2 =converter2.convert("99");
        System.out.println(val2);
        // ==============================================================================
        // 引用特定对象的实例方法
        Converter converter3 = from -> "aadadfaweaaa".indexOf(from);
        Integer val3 = converter3.convert("we");
        System.out.println(val3);

        Converter converter4 = "aadadfaweaaa"::indexOf;
        Integer val4 = converter4.convert("we");
        System.out.println(val4);

        // ==============================================================================
        // 引用某类对象的实例方法
        Mytest mytest = (a, b, c) -> a.substring(b,c);
        String str = mytest.test("Java I love you",2,9);
        System.out.println(str);

        //方法引用代替lambda表达式：因为用某类对象的实例方法
        // 函数式接口中被实现方法的第一个参数作为调用者
        // 后面的参数全部传给该方法作为参数
        Mytest mytest1 = String::substring;
        String str2 = mytest1.test("Java I love you",2,9);
        System.out.println(str2);
        // ==============================================================================
        // 引用构造器
        YourTest yourTest = title -> new JFrame(title);
        JFrame jFrame = yourTest.win("我的窗口");
        System.out.println(jFrame);
        // 构造器引用代替lambda表达式
        // 函数式接口中被实现方法的全部参数传给该构造器作为参数
        YourTest yourTest2 = JFrame::new;
        JFrame jFrame2 = yourTest2.win("我的窗口");
        System.out.println(jFrame2);
    }
}
@FunctionalInterface
interface Converter{
    Integer convert(String from);
}
@FunctionalInterface
interface Mytest{
    String test(String a, int b, int c);
}
@FunctionalInterface
interface YourTest{
    JFrame win(String title);
}