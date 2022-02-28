package IOTest.StreamTest.SerializableTest.selfSerializable.replace;

import java.io.*;
import java.util.ArrayList;

/**
 * Package: IOTest.StreamTest.SerializableTest.selfSerializable
 * <p>
 * Description： 更彻底的自定义机制，甚至可以在序列化对象时将该对象替换成其他对象。
 * 如果需要实现序列化某个对象时替换该对象，则应为序列化类提供特殊方法：
 *   ANY-ACCESS-MODIFIER object writeReplace() throw ObjectStreamException;
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 14:02
 * <p>
 * Version: 0.0.1
 */
// 下面Person类提供了writeObject（）和readObject两个方法，
// 其中writeObject方法在保存对象时将其name实例变量包装成Stringbuffer,并将其字符序列反转后再写入
// 在readObject方法中处理name的策略与此对应，先将读取的数据强制类型转换成StrignBuffer,再将其反转后赋给name实例变量
public class Person implements Serializable {
    private String name;
    private int age;
    // 注意此处没有提供无参数的构造器

    public Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }
    // 重写writeReplace方法，程序在序列化该对象之前，先调用该方法
    private Object writeReplace()throws ObjectStreamException {
        ArrayList<Object> list =new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
