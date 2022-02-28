import java.io.*;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 19:05
 * <p>
 * Version: 0.0.1
 */

public class WriteObject {
    public static void main(String[] args) {
        Person person = new Person("八疵", 5000);
     /*   try
                (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {

            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //============================================================================================================
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            Person person2 = (Person) (ois.readObject());
            System.out.println(person2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        //============================================================================================================

        Teacher teacher1 = new Teacher("饕餮", person);
        Teacher teacher2 = new Teacher("混沌", person);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));) {
            oos.writeObject(person);    person.setName("荒");
            oos.writeObject(teacher1);
            oos.writeObject(teacher2);
            oos.writeObject(teacher2);

            Person person3 = (Person) ois.readObject();
            Teacher teacher3 = (Teacher) ois.readObject();
            Teacher teacher4 = (Teacher) ois.readObject();
            Teacher teacher5 = (Teacher) ois.readObject();

            System.out.println("查看两个对象是否相等"+(person==person3));
            System.out.println(person3.getName());//应该是荒，相同对象只序列化一次，序列化后的值改变不会入尽序列//
            System.out.println("查看第一个序列化的引用对象是否和初始对象相等"+(teacher3.getStudent()==person3));
            System.out.println("查看第一个序列化的引用对象是否第二个引用对象相等"+(teacher4.getStudent()==person3));
            System.out.println("查看后两个的引用对象是否相等"+(teacher4.getStudent()==teacher5.getStudent()));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
