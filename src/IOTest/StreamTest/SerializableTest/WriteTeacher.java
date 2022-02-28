package IOTest.StreamTest.SerializableTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： java序列化机制采取了特殊的序列化算法
 * 1.所有保存到磁盘中的对象都有一个序列化编号
 * 2.当程序试图序列化一个对象时，程序将先检查该对象是否已经被序列化过，
 * 只有该对象从未（在本次虚拟机中）被序列化过，系统才会将该对象转换成字节序列并输出
 * 3.如果么偶个对象已经序列化过，程序将只是直接输出一个序列化编号，而不是再次重新序列化该对象
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 12:42
 * <p>
 * Version: 0.0.1
 */
public class WriteTeacher {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))
        ) {
            Person per =new Person("李四",25);
            Teacher t1 =new Teacher("王五",per);
            Teacher t2 =new Teacher("赵六",per);
            // 依次将4个对象写入输入流
            // 实际上之序列化了三个对象，而且两个teacher对象的student引用实际上是同一个Person对象。
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
