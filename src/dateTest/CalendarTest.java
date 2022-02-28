package dateTest;

import java.util.Calendar;
import java.util.Date;

/**
 * Package: dateTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 12:20
 * <p>
 * Version: 0.0.1
 */
public class CalendarTest {
    public static void main(String[] args) {

    // 创建一个默认的Calendar对象
    Calendar calendar = Calendar.getInstance();
    // 取出年、月、日
    System.out.println(calendar.get(Calendar.YEAR));
    System.out.println(calendar.get(Calendar.MONTH));// 月从0开始的
    System.out.println(calendar.get(Calendar.DATE));
    // 分别设置年月日时分秒
    calendar.set(1998,4,9,12,32,23);
    System.out.println(calendar.getTime());
    calendar.add(Calendar.YEAR,-1);
    System.out.println(calendar.getTime());
    calendar.add(Calendar.MONTH,-8);
    System.out.println(calendar.getTime());
    Date date = calendar.getTime();// 从Calendar对象中取出date对象
    // 通过date对象获得对应的Calendar对象
    // 因为Calendar/GregorianCalendar没有构造函数可以接受Date对象
    // 所以必须先获得一个Calender实例然后调用其setTime()方法
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(date);
    }

}
