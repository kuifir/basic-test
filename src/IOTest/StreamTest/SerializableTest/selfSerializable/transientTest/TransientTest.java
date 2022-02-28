package IOTest.StreamTest.SerializableTest.selfSerializable.transientTest;

import java.io.*;

/**
 * Package: IOTest.StreamTest.SerializableTest.selfSerializable.transientTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 13:49
 * <p>
 * Version: 0.0.1
 */
public class TransientTest {
    // 先序列化一个Person对象没然后再反序列化该Person对象，得到反序列化的Person对象后程序输出该对象的age实例变量
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
                // 创建一个ObjectInptuStream输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt"));
        ) {
            Person per =new Person("张三",25);
            // 系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            Person p = (Person) ois.readObject();
            System.out.println(p.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
