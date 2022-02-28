package IOTest.StreamTest.SerializableTest.selfSerializable.replace;

import java.io.*;
import java.util.ArrayList;

/**
 * Package: IOTest.StreamTest.SerializableTest.selfSerializable.replace
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 14:31
 * <p>
 * Version: 0.0.1
 */
public class ReplaceTest {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
                // 创建一个ObjectInputStream输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("replace.txt"));
        ) {
            Person person =new Person("张三",25);
            // 系统将per对象转换成字节序列并输出
            oos.writeObject(person);
            // 反序列化读取得到的是ArrayList
            ArrayList list = (ArrayList) ois.readObject();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
