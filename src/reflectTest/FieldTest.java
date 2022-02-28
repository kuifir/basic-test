package reflectTest;

import java.lang.reflect.Field;

/**
 * Package: reflectTest
 * <p>
 * Description： TODO获取成员变量
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 21:55
 * <p>
 * Version: 0.0.1
 */
class Person{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "FieldTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class FieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 船舰一个Person对象
        Person p =new Person();
        // 获取Person类对应的Class类
        Class<Person> personClazz = Person.class;
        // 获取Person 的名为name的成员变量
        // 使用getDeclaredField()方法表明可获取各种访问控制符的成员变量
        Field nameField = personClazz.getDeclaredField("name");
        // 设置通过反射访问该成员变量时取消访问权限检查
        nameField.setAccessible(true);
        // 调用set()方法为p对象的name成员变量设置值
        nameField.set(p,"lll.llll");
        // 获取Person类名为age的成员变量
        Field ageField = personClazz.getDeclaredField("age");
        // 设置通过反射访问该成员变量时取消访问权限
        ageField.setAccessible(true);
        //调用setInt()方法为p对象的age成员变量设置值
        ageField.setInt(p,30);
        System.out.println(p);
    }
}
