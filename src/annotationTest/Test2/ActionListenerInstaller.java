package annotationTest.Test2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * Package: annotationTest.Test2
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 0:23
 * <p>
 * Version: 0.0.1
 */
public class ActionListenerInstaller {
    public static void processAnnotations(Object obj){
        try {
            // 获取obj对象的类
            Class c1 = obj.getClass();
            // 获取指定obj对象的所有成员变量，并遍历每个成员变量
            for(Field f :c1.getDeclaredFields()){
                // 将该成员变量设置成可自由访问
                f.setAccessible(true);
                //获取该成员变量上ActionListenerFor类型的Annotation
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                // 获取成员变量f的值
                Object fObj =f.get(obj);
                // 如果f 是AbstractButton的实例，且a 不为 null
                if(a !=null && fObj !=null && fObj instanceof AbstractButton){
                    Class<? extends ActionListener> listenerClazz =a.listener();
                    //使用反射来创建listener的实例对象
                    ActionListener a1 =listenerClazz.newInstance();
                    AbstractButton ab =(AbstractButton) fObj;
                    // 为ab按钮添加事件监听器
                    ab.addActionListener(a1);
                }

            }
        }catch ( Exception e){
            e.printStackTrace();
        }
    }
}
