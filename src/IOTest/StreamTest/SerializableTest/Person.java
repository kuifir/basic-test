package IOTest.StreamTest.SerializableTest;

import java.io.Serializable;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： 实现Serializable接口即表示可序列化
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 11:44
 * <p>
 * Version: 0.0.1
 */
public class Person implements Serializable {
    private String name;
    private int age;
    // 注意此处没有提供无参构造器

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
