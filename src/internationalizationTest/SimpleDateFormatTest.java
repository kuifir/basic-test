package internationalizationTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Package: internationalizationTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 22:10
 * <p>
 * Version: 0.0.1
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date d =new Date();
        System.out.println(d);
        // 创建一个simpleDateFormat对象
        SimpleDateFormat sdf1 =new SimpleDateFormat("Gyyyy年中第D天");
        // 将d格式化成日期，输出：公元2021年中第101天
        String dateStr = sdf1.format(d);
        System.out.println(dateStr);
        // 一个非常特殊的字符串
        String str = "21###三月##21";
        SimpleDateFormat sdf2 =new SimpleDateFormat("y###MMM##d");
        //将日期字符串解析成日期
        System.out.println(sdf2.parse(str));
    }
}
