//package reflectTest;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Package: reflectTest
 * <p>
 * Description： TODO获取方法参数信息.命令行执行
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 14:03
 * <p>
 * Version: 0.0.1
 */
public class MethodParameterTest {
    public static void main(String[] args) throws NoSuchMethodException {
        // 获取String的类
        Class<Test> clazz = Test.class;
        // 获取String类的带两个参数的replace（）方法
        Method replace = clazz.getMethod("replace", String.class, List.class);
        // 获取指定方法的参数个数
        System.out.println("replace方法参数个数：" + replace.getParameterCount());
        // 获取replace所有参数信息
        Parameter[] parameters = replace.getParameters();
        int index = 1;
        // 遍历所有参数
        for (Parameter parameter : parameters) {
            // javac -parameters -d . -encoding UTF-8 MethodPArameterTest.java
            if(parameter.isNamePresent()){
                System.out.println("第"+index++ + "个参数信息=======================");
                System.out.println("参数名：" +parameter.getName());
                System.out.println("形参类型：" +parameter.getType());
                System.out.println("泛型类型：" +parameter.getParameterizedType());
            }
        }

    }
}

class Test {
    public void replace(String sr, List<String> list) {
    }

    ;
}