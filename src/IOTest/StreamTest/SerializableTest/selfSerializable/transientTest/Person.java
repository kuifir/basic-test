package IOTest.StreamTest.SerializableTest.selfSerializable.transientTest;

import java.io.Serializable;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： 在实例前面使用transient关键字修饰，可以指定java序列化时无须理会该实例变量
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 11:44
 * <p>
 * Version: 0.0.1
 */
public class Person implements Serializable {
    private String name;
    private transient int age;

    public Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
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
