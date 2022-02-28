package InnerClass;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 22:47
 * <p>
 * Version: 0.0.1
 */
public class InnerClassTest {
    public static void main(String[] args) {
        int age = 8;
        age =2 ;
        A a =new A(){

            @Override
            public void test() {
//               从内部类引用的本地变量必须是最终变量或实际上的最终变量
//                System.out.println(age);
            }
        };
        a.test();
    }
}
interface A {
    void test();
}