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
public class Teacher implements Serializable {



    private String name;
    private Person student;
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
    public Teacher(String name, Person student) {
        this.name = name;
        this.student = student;
    }
    public void setStudent(Person student) {
        this.student = student;
    }

    public Person getStudent() {
        return student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
