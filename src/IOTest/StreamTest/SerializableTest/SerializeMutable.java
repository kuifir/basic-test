package IOTest.StreamTest.SerializableTest;

import java.io.*;

/**
 * Package: IOTest.StreamTest.SerializableTest
 * <p>
 * Description： java序列化机制使然：
 * 如果多次序列化同一个Java对象时，只有第一次序列化时才会把该Java对象转换成字节序列并输出
 * 这样可能引起一个潜在的问题——当程序序列化一个可变对象时，
 * 只有第一次使用writeObject()方法输出时才会将该对象转换成字节序列并输出，当程序再次调用writrObject（）方法时
 * 程序只是输出前面序列化编号，即使后面该对象的实例变量值已被改变，改变的实例变量值也不会被输出。
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 13:22
 * <p>
 * Version: 0.0.1
 */
public class SerializeMutable {
    public static void main(String[] args) {
        try (
                //创建一个ObjectOutputStream输出流
                ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("mutable.txt"));
                // 创建一个ObjectInputStream输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mutable.txt"));
                ){
            Person per =new Person("张三",25);
            // 系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            // 改变per对象的name实例变量的值
            per.setName("李四");
            // 系统只是输出序列化编号，所以改变后的name不会被序列化
            oos.writeObject(per);
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            // 下面输出true，即反序列化后p1 等于p2
            System.out.println(p1==p2);
            // 下面依然看到输出“张三”，即改变后的实例变量没有被序列化
            System.out.println(p2.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
