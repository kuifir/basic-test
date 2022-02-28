package IOTest.StreamTest.SerializableTest.selfSerializable.cuntom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Package: IOTest.StreamTest.SerializableTest.selfSerializable
 * <p>
 * Description： 自定义序列化
 * 在序列化和反序列化过程中需要特殊处理的类应该提供如下特殊签名的方法，这些特殊的方法用以实现自定义序列化
 * 1. private void writeObject(java.io.ObjectOutputStream out) throws IOException;
 * 2. private void readObject(java.io.ObjectOutputStream out) throws IOException,ClassNotfoundException;
 * 3. private void readObjectNoData() throws ObjectStreamException;
 * writeObject: 写入特定类的实例状态，以便相应readObject方法可以恢复它，通过重写该方法可以完全获得对序列化机制的控制
 * readObject: 负责从流中读取并恢复对象实例变量，通过重写该方法们可以完全获得对反序列化机制的控制
 * readObjectNoData：当序列化流不完整时，可以用来正确初始化反序列化的对象
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        // 将name实例变量值反转后写入二进制流
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);

    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // 将读取的字符串反转后付给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age =in.readInt();
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
