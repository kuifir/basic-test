package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Package: regularExpression
 * <p>
 * Description： 数量标识符三种模式：贪婪模式，勉强模式，占有模式
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 17:42
 * <p>
 * Version: 0.0.1
 */
public class patternTest {
    public static void main(String[] args) {
        String str = "hello ,java!";
        //数量标识符贪婪模式的正则表达式（默认）--匹配到无法匹配位置，
        System.out.println(str.replaceFirst("\\w*","█"));
        // 勉强模式的正则表达式
        System.out.println(str.replaceFirst("\\w*?","█"));
        // Pattern 对象是正则表达式编译后在内存中的表示形式，因此，正则表达式字符串必须现被编译为Pattern对象
        // 然后再利用该Pattern对象创建对应的Matcher对象。
        // 执行匹配所涉及的状态保留在Matcher对象中，多个Matcher对象可共享一个Pattern对象

        Pattern p =Pattern.compile("a*b");// 将一个字符串编译成Pattern对象
        // 使用Pattern对象创建Matcher对象
        Matcher m = p.matcher("aaaab");
        boolean b = m.matches();
        System.out.println(b);
    }
}
