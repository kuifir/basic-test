package reflectTest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Package: reflectTest
 * <p>
 * Description： TODO 获取Class对象里的信息
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 12:14
 * <p>
 * Version: 0.0.1
 */
// 定义一个可重复注解
@Repeatable(Annos.class)
@interface Anno{

}
@Retention(RetentionPolicy.RUNTIME)
@interface Annos{
    Anno[] value();
}
// 使用4个注解修饰该类
@SuppressWarnings("unchecked")
@Deprecated // 注解含义：方法过时
//使用可重复注解修饰该类
@Anno
@Anno
public class ClassTest {
    // 为该类定义一个私有的构造器
    private ClassTest (){

    }
    // 为该类定义一个有参的构造器
    public ClassTest(String name){
        System.out.println("执行有参数的构造器");
    }
    // 定义一个无参数的info方法
    public void info(){
        System.out.println("执行无参数的info方法");
    }
    // 定义一个有参数的info方法
    public void info(String str){
        System.out.println("执行有参数的info方法，其str值是："+str);
    }
    // 定义一个测试用的内部类
    class Inner{
    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        // 下面代码可以获取ClassTest对应的Class
        Class<ClassTest> clazz = ClassTest.class;
        // 获取该Class对象所对应的类的全部构造器
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest全部构造器如下:==============");
        for (Constructor ctor: ctors) {
            System.out.println(ctor);
        }
        // 获取该Class对象所对应类的全部public构造器
        Constructor[] pubctors = clazz.getConstructors();
        System.out.println("ClassTest的全部Public构造器如下：================");
        for(Constructor pubctor: pubctors){
            System.out.println(pubctor);
        }
        // 获取该Class对象所对应类的全部Public方法
        Method[] mtds =clazz.getMethods();
        System.out.println("ClasTest全部public方法如下==================");
        for (Method method : mtds){
            System.out.println(method);
        }
        // 获取该Class对象所对应类的指定方法
        System.out.println("ClassTest里带一个字符串参数的info方法为："+clazz.getMethod("info",String.class));
        // 获取该Class对象所对应类的全部注解
        Annotation[] anns =clazz.getAnnotations();
        System.out.println("ClassTest的全部Annotation如下：===============");
        for(Annotation ann: anns){
            System.out.println(ann);
        }
        System.out.println("该Class元素上的@suppressWarning注解为："+ Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));
        System.out.println("该Class元素上的@Anno注解为" + Arrays.toString(clazz.getAnnotationsByType(Anno.class)));
        // 获取该Class对象所对应类的全部内部类
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下：");
        for (Class inner: inners){
            System.out.println(inner);
        }
        // 使用Class.forName()方法加载ClassTest的Inner内部类
        Class inClazz = Class.forName("reflectTest.ClassTest$Inner");
        // 通过getDeclaringClass()访问该类所在的外部类
        System.out.println("inClazz对应类的外部类为： "+ inClazz.getDeclaringClass());
        System.out.println("ClassTest的包为"+ clazz.getPackage());
        System.out.println("ClassTest的父类为"+ clazz.getSuperclass());
    }
}
