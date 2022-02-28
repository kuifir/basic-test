package dateTest;

import java.time.*;

/**
 * Package: dateTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 13:23
 * <p>
 * Version: 0.0.1
 */
public class NewDatePackageTest {
    public static void main(String[] args) {
        // 下面是关于Clock的用法
        // 获取当前Clock
        Clock clock = Clock.systemUTC();
        // 通过Clock获取当前时刻
        System.out.println("当前时刻为："+clock.instant());
        // 获取clock对应的毫秒数，与System.currentTimeMillis()输出相同
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        // 下面是关于Duration的用法
        // Duration代表持续时间，改了类可以非常方便的获取一段时间
        Duration d =Duration.ofSeconds(6000);
        System.out.println("6000秒相当于——"+d.toMinutes()+"分");
        System.out.println("6000秒相当于——"+d.toHours()+"时");
        System.out.println("6000秒相当于——"+d.toDays()+"天");
        // 在clock基础上增加6000秒，返回新的Clock
        Clock clock2 =Clock.offset(clock,d);
        System.out.println("当前时刻加6000秒为："+clock2.instant());

        // 下面是关于Instant的用法
        // 获取当前时间
        Instant instant = Instant.now();
        System.out.println(instant);
        // Instant 添加6000秒返回新的instant
        Instant instant2 =instant.plusSeconds(6000);
        System.out.println(instant2);
        // 根据字符串解析Instant对象
        Instant instant3 = Instant.parse("2021-08-17T06:47:35.401Z");
        System.out.println(instant3);
        // 在instant3的基础上添加5小时4分钟
        Instant instant4 =instant3.plus(Duration.ofHours(8).plusMinutes(4));
        System.out.println(instant4);
        // 获取instant4 5天之前的时刻
        Instant instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);
        // 下面是关于localDate的用法
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //获取2021年第146天
        localDate = LocalDate.ofYearDay(2021,146);
        System.out.println(localDate);
        // 设置为2021年5月21日
        localDate =LocalDate.of(2021, Month.MAY,21);
        System.out.println(localDate);
        // 下面是关于LocalTime的用法
        // 获取当前时间
        LocalTime localTime =LocalTime.now();
        System.out.println(localTime);
        //设置为22：30
        localTime=LocalTime.of(22,30);
        System.out.println(localTime);
        //返回一天中的第5503秒
        localTime =LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);
        // 下面是关于localDateTime的用法
        // 获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 当前日期时间加上25小时3分钟
        LocalDateTime future =localDateTime.plusHours(25).plusMinutes(3);
        System.out.println("当前日期时间加上25小时3分钟:"+future);
        // 下面是关于Year、YearMonth、MonthDay的用法示例

    }
}
