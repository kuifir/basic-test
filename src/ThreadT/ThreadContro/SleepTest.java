package ThreadT.ThreadContro;

import java.util.Date;

/**
 * Package: ThreadT.ThreadContro
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 16:54
 * <p>
 * Version: 0.0.1
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间"+new Date());
            Thread.sleep(1000);
        }
    }
}
