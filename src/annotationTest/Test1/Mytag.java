package annotationTest.Test1;

/**
 * Package: annotationTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 23:17
 * <p>
 * Version: 0.0.1
 */
public @interface Mytag {
    String name() default "xiaoming";
    int age() default 14;

}
