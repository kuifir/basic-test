package IOTest.StreamTest.SerializableTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： 一个类实现了Serializable接口，该类的对象就是可序列化的
 * 序列化该对象的两个步骤：
 * 1.创建一个ObjectOutputStream，这个输出流是一个处理流，所哟必须建立在其他节点流基础上
 * 2.调用ObjectOutputStream对象的writeObject()方法输出可序列化对象
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 11:46
 * <p>
 * Version: 0.0.1
 */
public class WriteObject {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream 输出流
                ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("object.txt"))
                ) {
            Person per =new Person("张三",25);
            // 将per对象写入输出流
            oos.writeObject(per);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
