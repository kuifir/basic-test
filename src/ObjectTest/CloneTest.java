package ObjectTest;

/**
 * Package: ObjectTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 17:42
 * <p>
 * Version: 0.0.1
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        User u1 = new User(29);
        // clone 得到u1对象副本
        User u2 = u1.clone();
        // 判断u1 u2是否相同
        System.out.println(u1 == u2);
        //判断u1 u1的address是否相同
        System.out.println(u1.address==u2.address);
    }
}
class Address{
    String detail;

    public Address(String detail) {
        this.detail = detail;
    }
}
class User implements Cloneable{
    int age;
    Address address;

    public User(int age) {
        this.age = age;
        address =new Address("啊啊啊啊");
    }
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}