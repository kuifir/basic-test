package ThreadT.threadSynchronized.synchronizedMethod;

import java.util.Objects;

/**
 * Package: ThreadT.threadSynchronized.AccountQuestion
 * <p>
 * Description： 同步方法
 * 与同步代码块对应，Java的多线程安全支持还提供了同步方法，
 * 同步方法就是使用synchronized关键字来修饰某个方法，
 * 对于synchronized修饰的实例方法（非static）而言，无需显示指定同步监视器，
 * 同步方法的同步监视器是this，也就是调用该方法的对象
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 18:15
 * <p>
 * Version: 0.0.1
 */
// 将Account类balance的访问设置成线程安全的，那么只要把修改balance的方法变成同步方法即可
public class Account {
    // 封装账户编号、账户余额的两个成员变量
    private  String accountNo;
    private  double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }
    // 提供一个线程安全的draw()方法来完成取钱操作
    public synchronized void draw(double drawAmount){
        // 账户余额大于取钱数目
        if(balance >= drawAmount){
            // 吐出钞票
            System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改余额
            balance -= drawAmount;
            System.out.println("\t余额为"+balance);
        }else {
            System.out.println(Thread.currentThread().getName()+"取钱失败！余额不足！");
        }
    }
    // 根据accountNo来重写hashCode()和equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNo, account.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }
}
