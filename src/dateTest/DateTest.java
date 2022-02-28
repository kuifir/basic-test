package dateTest;

import java.util.Date;

/**
 * Package: dateTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 12:02
 * <p>
 * Version: 0.0.1
 */
public class DateTest {
    public static void main(String[] args) {
        Date date =new Date();
        // 获取当前时间100ms的时间
        Date date2 = new Date(System.currentTimeMillis()+100);
        System.out.println(date2);
        System.out.println(date.compareTo(date2));
        System.out.println(date.before(date2));

    }
}
