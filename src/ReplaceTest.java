import java.io.*;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 23:04
 * <p>
 * Version: 0.0.1
 */
public class ReplaceTest {
    public static void main(String[] args) {
        PersonTransient p=new PersonTransient("小明",20);
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("transient.txt"));
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("transient.txt"));

        ) {
            oos.writeObject(p);
            PersonTransient p2= (PersonTransient) ois.readObject();
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
