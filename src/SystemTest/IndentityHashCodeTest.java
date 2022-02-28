package SystemTest;

/**
 * Package: SystemTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 16:43
 * <p>
 * Version: 0.0.1
 */
public class IndentityHashCodeTest {
    public static void main(String[] args) {
        // 下面程序中s1和s2是两个不同的对象
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // String重写了hashCode()方法——改为根据字符序列计算hashCode值
        System.out.println(s1.hashCode()+"======"+s2.hashCode());
        System.out.println(s1==s2);
        // s1 和s2是不同的字符串对象，所以他们的indentityHashCode值不同
        System.out.println(System.identityHashCode(s1)+"----"+System.identityHashCode(s2));
        String s3 ="java";
        String s4 ="java";
        // s3 和s4 是相同的字符串对象，所以他们的identityHashCode值相同
        System.out.println(System.identityHashCode(s3)+"====="+System.identityHashCode(s4));
        System.out.println(s3==s4);
    }
}
