package ThreadT.threadSynchronized.lock;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package: ThreadT.threadSynchronized.AccountQuestion
 * <p>
 * Description： 使用ReentrantLock（可重入锁）实现控制线程安全
 * Lock、ReadWriteLock是Java5提供的两个跟接口
 * 为Lock提供了ReentrantLock（可重入锁）实现类
 * 为ReadWriteLock提供了ReentrantReadWriteLock实现类
 * 使用该Lock对象可以显式的加锁、释放锁
 * 使用ReentrantLock对象进行同步，加锁和释放锁出现在不同的作用范围内时
 * 通常建议使用finally块来确保在必要时释放锁
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 18:15
 * <p>
 * Version: 0.0.1
 */
public class Account {
    // 定义锁对象
    private final ReentrantLock lock =new ReentrantLock();
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

    // 因为是账户余额不允许随便修改，所以职位balance提供getter方法
    public double getBalance() {
        return balance;
    }
    // 提供一个线程安全的draw()方法来完成取钱操作
    public void draw(double drawAmount){
        // 加锁
        lock.lock();
        try {
            // 账户余额大于取钱数目
            if(balance>=drawAmount){
                // 吐出钞票
                System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改余额
                balance -=drawAmount;
                System.out.println("\t余额为"+ balance);
            }else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
            }
        }finally {
            // 修改完成，释放锁
            lock.unlock();
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
