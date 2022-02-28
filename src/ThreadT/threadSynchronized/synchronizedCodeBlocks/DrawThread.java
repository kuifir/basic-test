package ThreadT.threadSynchronized.synchronizedCodeBlocks;

/**
 * Package: ThreadT.threadSynchronized.AccountQuestion
 * <p>
 * Description： 为了解决同步问题，java的多线程支持引入了同步监视器来解决问题
 * 使用同步监视器的通用方法就是同步代码块
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
        // 使用account作为同步监视器，任何线程进入下面同步代码块之前
        // 必须先获得对account账户的锁定————其他线程无法获得锁，也就无法修改它
        // 这种做法符合“加锁->修改->释放锁”的逻辑
        synchronized (account) {
            // 账户余额大于取钱数目
            if (account.getBalance() >= drawAmount) {
                // 吐出钞票
                System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票" + drawAmount);
                // 加强暂停，阻塞线程，让其他线程运行
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改余额
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额为：" + account.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
            }
        }
        // 同步代码块结束，该线程释放同步锁
    }
}
