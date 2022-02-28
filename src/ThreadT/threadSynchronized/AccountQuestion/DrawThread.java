package ThreadT.threadSynchronized.AccountQuestion;

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
        if(account.getBalance()>=drawAmount){
            // 吐出钞票
            System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票"+drawAmount);
            // 加强暂停，阻塞线程，让其他线程运行
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改余额
            account.setBalance(account.getBalance()-drawAmount);
            System.out.println("\t余额为："+account.getBalance());
        }else {
            System.out.println(Thread.currentThread().getName()+"取钱失败！余额不足！");
        }
    }
}
