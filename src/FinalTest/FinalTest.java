package FinalTest;

/**
 * Package: FinalTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 11:56
 * <p>
 * Version: 0.0.1
 */
public class FinalTest {
    private final Name name;

    public FinalTest(Name name) {
//        this.name = name;
        this.name = new Name(name.getFirstName(),name.getLastName());
    }

    public Name getName() {
//        return name;
        return new Name(name.getFirstName(),name.getLastName());
    }

    public static void main(String[] args) {
        Name n =new Name("悟空","孙");
        FinalTest finalTest =new FinalTest(n);
        System.out.println(finalTest.getName().getFirstName());

        n.setFirstName("八戒");
        System.out.println(finalTest.getName().getFirstName());

    }

}

class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}