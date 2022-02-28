package annotationTest.Test2;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package: annotationTest.Test2
 * <p>
 * Description： TODO简化事件编程
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 0:03
 * <p>
 * Version: 0.0.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor{
    // 定义一个成员变量，用于设置元数据
    // 该listener 成员变量用于保存监听器实现类
    Class<? extends ActionListener> listener();
}
