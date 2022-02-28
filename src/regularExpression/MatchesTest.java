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
 * Date: Created in 2021/8/17 18:22
 * <p>
 * Version: 0.0.1
 */
public class MatchesTest {
    public static void main(String[] args) {
        String [] mails = {
          "kongyueeku@163.com",
          "kongyueeku@gmail.com",
          "ligang@crazyit.org",
          "wawa@abc.xx",
        };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher =null;
        for (String mail: mails) {
            if(matcher == null){
                matcher = mailPattern.matcher(mail);
            }else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮箱地址";
            System.out.println(result);
        }

    }
}
