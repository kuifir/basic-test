package ThreadT.threadSynchronized.lock;

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
        // 账户余额大于取钱数目
        account.draw(drawAmount);
    }
}
