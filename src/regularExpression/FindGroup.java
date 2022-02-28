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
 * Date: Created in 2021/8/17 17:56
 * <p>
 * Version: 0.0.1
 */
public class FindGroup {
    public static void main(String[] args) {
        // 使用字符串模拟从网络上得到的网页源码
        String str = "尽快联系13500006666" +
                "好评电话13611125565" +
                "买电脑电话15899903312";
        // 创建一个Parttern 对象，并用它建立一个Matcher对象
        // 该正则表达式之抓取13x和15x段的手机号
        // 实际要抓哪些段话号码，只要修改正则表达式即可
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
