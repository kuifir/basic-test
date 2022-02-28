import java.io.Serializable;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 19:08
 * <p>
 * Version: 0.0.1
 */
public class PersonTransient implements Serializable {


    private  String name;
    private transient int age;

    public PersonTransient(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
