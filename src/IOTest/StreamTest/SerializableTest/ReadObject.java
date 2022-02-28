package IOTest.StreamTest.SerializableTest;

import java.io.*;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： 如果希望从二进制流中恢复Java对象则需要使用反序列化，反序列化步骤如下
 * 1.创建一个ObjectInputStream输入流，这个输入流是一个处理流，所以必须建立在其他节点流的基础上
 * 2.调用ObjectInputSteam 对象的readObject（）方法读取流中的对象，该方法返回一个Object类型的Java对象，
 * 如果已知道Java对象的类型，则可以将该对象强制类型转换成其真实的类型。
 * 注意，反序列化读取的仅仅是Java对象的数据，而不是Java类，因此反序列化恢复java对象时，
 * 必须提供该Java对象所属类的class文件，否则会引发ClassNotFoundException异常
 *
 * 另外要注意，Person类只有一个有参数的构造器，没有无参数的构造器，而且该构造器内有一个普通的打印语句
 * 当反序列化java对象时，并没有看待程序调用该构造器，这表明反序列化机制无需通过构造器来初始化java对象。
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 11:55
 * <p>
 * Version: 0.0.1
 */
public class ReadObject {
    public static void main(String[] args) {
        // 创建一个ObjectInputStream对象
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
        ) {
            // 从输入流中读取一个java对象，并将其强制类型转换为Person类
            Person p = (Person) ois.readObject();
            System.out.println("名字为"+p.getName()+"\n年龄为"+p.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
