package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Package: regularExpression
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 18:14
 * <p>
 * Version: 0.0.1
 */
public class StartEnd {
    public static void main(String[] args) {
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        String str = "Java is very easy";
        System.out.println("目标字符串是"+str);
        Matcher m = Pattern.compile("\\w+").matcher(str);
        while (m.find()){
            System.out.println(m.group()+"子字符串的起始位置："+m.start()+", 其结束位置是："+m.end());
        }
    }
}
