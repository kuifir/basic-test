package annotationTest.Fktag;

/**
 * Package: annotationTest.Fktag
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 9:45
 * <p>
 * Version: 0.0.1
 */
@Fktag(age = 5)
@Fktag(name = "java1", age = 6)
public class FkTagTest {
    public static void main(String[] args) {
        Class<FkTagTest> clazz =FkTagTest.class;
        /*使用Java 8新增的getDeclaredAnnotationsByType()方法获取修饰FkTagTEst 类的多个@Fktaag注解*/
        Fktag[] tags =clazz.getDeclaredAnnotationsByType(Fktag.class);
        // 遍历修饰FkTagTest类的多个@Fktag注解
        for (Fktag tag : tags){
            System.out.println(tag.name()+"-------->"+tag.age());
        }
        /*使用传统的getDeclaredAnnotation()方法获取修饰Fktag类的@Fktag注解*/
        Fktags container = clazz.getDeclaredAnnotation(Fktags.class);
        System.out.println(container);
    }
}
