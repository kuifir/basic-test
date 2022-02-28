package ThreadT.threadSynchronized.lock;

/**
 * Package: ThreadT.threadSynchronized.AccountQuestion
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 18:33
 * <p>
 * Version: 0.0.1
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account =new Account("123456",1000);
        DrawThread target =new DrawThread(account,800);
        DrawThread target2 =new DrawThread(account,800);
        new Thread(target,"甲").start();
        new Thread(target2,"乙").start();
    }
}
