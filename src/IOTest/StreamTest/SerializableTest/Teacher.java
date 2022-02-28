package IOTest.StreamTest.SerializableTest;

import java.io.Serializable;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： 假如某个类的成员变量的类型不是基本类型或String类型，而是一个引用类型
 * 那么这个引用类型必须是可序列化的，否则拥有该类型成员变量的类也是不可序列化的
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 12:33
 * <p>
 * Version: 0.0.1
 */
public class Teacher implements Serializable {
    private String name;
    // 只有Person是可序列化的，Teacher才是可序列化的，如果Person类不可序列化，
    // 则无论Teacher是否实现了Serializable、Externalizable接口，Teacher类都是不可序列化的
    private Person student;

    public Teacher(String name, Person student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }
}
