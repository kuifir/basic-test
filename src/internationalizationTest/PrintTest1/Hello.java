package internationalizationTest.PrintTest1;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Package: internationalizationTest.PrintTest1
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 18:51
 * <p>
 * Version: 0.0.1
 */
public class Hello {
    public static void main(String[] args) {
        // 取得系统默认的国家、语言环境
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        // 根据指定的国家、语言环境加载资源文件(mess需要加上路径)
        ResourceBundle bundle =ResourceBundle.getBundle("internationalizationTest.PrintTest1.mess",myLocale);
        //打印从资源文件中取得的信息
        System.out.println(bundle.getString("hello"));
    }
}
