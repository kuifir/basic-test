package internationalizationTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Package: internationalizationTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 22:27
 * <p>
 * Version: 0.0.1
 */
public class NewFormatterTest {
    public static void main(String[] args) {

        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                // 直接使用常量创建DateTimeFormatter格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                // 使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG),
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM),
                //根据模式字符串来创建DateFormatter格式器
                DateTimeFormatter.ofPattern("Gyyyy%%MM%%dd HH:mm:ss")
        };
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        //依次使用不同的格式器对LocalDateTime进行格式化
        for(int i=0;i<formatters.length;i++){
            // 下面两行代码作用相同
            System.out.println(date.format(formatters[i]));
            System.out.println(formatters[i].format(date));
        }
    }

}
