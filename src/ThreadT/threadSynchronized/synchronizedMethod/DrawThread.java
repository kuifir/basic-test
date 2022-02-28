package ThreadT.threadSynchronized.synchronizedMethod;

/**
 * Package: ThreadT.threadSynchronized.AccountQuestion
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 18:20
 * <p>
 * Version: 0.0.1
 */
public class DrawThread implements Runnable{
    // 模拟用户账户
    private Account account;
    // 当前取钱线程所希望取的钱数
    private double drawAmount;

    public DrawThread(Account account, double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }
    // 当多个线程修改同一个共享数据时，将涉及安全问题
    @Override
    public void run() {
        // 直接调用account对象的draw()方法来执行取钱操作
        // 同步方法的同步监视器是this，this代表调用draw()方法的对象
        // 也就是说，线程进入draw()方法之前们必须先对account加锁
        account.draw(drawAmount);
    }
}
