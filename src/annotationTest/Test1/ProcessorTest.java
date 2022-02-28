package annotationTest.Test1;

import java.lang.reflect.Method;

/**
 * Package: annotationTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 23:38
 * <p>
 * Version: 0.0.1
 */
public class ProcessorTest {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int filed = 0;
        for (Method m : Class.forName(clazz).getMethods()) {
            // 如果该方法使用了@Testable修饰
            if(m.isAnnotationPresent(Testable.class)){
                try{
                    // 调用m方法
                    m.invoke(null);
                    //测试成功，passed计数器加1
                    passed++;
                } catch (Exception e) {
                   System.out.println("方法"+m+"运行失败，异常："+ e.getCause());
                   //测试出现一擦汗给你，failed计数加1
                    filed++;
                }
            }
        }
        // 统计测试结果
        System.out.println("共运行了："+(passed+filed)+"个方法");
        System.out.println("成功了："+(passed)+"个方法");
        System.out.println("失败了："+(filed)+"个方法");
    }
}
