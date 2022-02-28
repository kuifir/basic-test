package classLoadTest;

/**
 * Package: classLoadTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 15:02
 * <p>
 * Version: 0.0.1
 */
public class Test {
//    static int b =9;
    static {
        b= 6;
        System.out.println("------------");
    }
    static int a =5;
    static int b =9;
    static int c ;

    public static void main(String[] args) {
        System.out.println(Test.b);
    }
}
