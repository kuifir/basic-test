package annotationTest.Fktag;

import java.lang.annotation.*;

/**
 * Package: annotationTest.Fktag
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 9:39
 * <p>
 * Version: 0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Fktags.class)
public @interface Fktag {
    String name() default "java";
    int age();
}
