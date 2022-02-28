package annotationTest.Test1;

/**
 * Package: annotationTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 22:13
 * <p>
 * Version: 0.0.1
 */
public class AnnotationTest {
    @Testable
    public static void m1(){}
    public static void m2(){}
    @Testable
    public static void m3() throws InterruptedException {
        throw new InterruptedException("参数出错了");
    }
    public static void m4(){}
    @Testable
    public static void m5() {
    }
    public static void m6(){}
    @Testable
    public static void m7() {
        throw new RuntimeException("程序业务出现异常");
    }
    public static void m8(){}
}
