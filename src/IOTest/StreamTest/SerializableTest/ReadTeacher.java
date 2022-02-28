package IOTest.StreamTest.SerializableTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 12:57
 * <p>
 * Version: 0.0.1
 */
public class ReadTeacher {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectInputStream输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))
        ) {
            // 依次读取ObjectInputStream输入流的4个对象
            Teacher t1 = (Teacher) ois.readObject();
            Teacher t2 = (Teacher) ois.readObject();
            Person p = (Person) ois.readObject();
            Teacher t3 = (Teacher) ois.readObject();
            // 输出true
            System.out.println("t1的student引用和p是否相同"+(t1.getStudent()==p));
            // 输出true
            System.out.println("t2的student引用和p是否相同"+(t2.getStudent()==p));
            // 输出true
            System.out.println("t2和t3是否是同一个对象"+(t2==t3));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
