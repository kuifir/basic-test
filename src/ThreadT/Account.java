package ThreadT;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Package: ThreadT
 * <p>
 * Description： 事务测试使用的类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 18:40
 * <p>
 * Version: 0.0.1
 */
public class Account {
    private String accoundNo;
    private Double balance;

    //3.ReenreantLock显式加锁解锁同步锁
    private final ReentrantLock lock = new ReentrantLock();

    public void draw3(Double drawAmount) {
        lock.lock();
        try {
            if (balance >= drawAmount) {
                //为了演示在这个过程中另一个线程进入运行
                Thread.sleep(1000);
                setBalance(balance - drawAmount);
                System.out.println(Thread.currentThread().getName() + "========》操作成功");
                System.out.println(Thread.currentThread().getName() + "========》现余额为" + getBalance());

            } else {
                System.out.println(Thread.currentThread().getName() + "------->error：余额不足");
                System.out.println(Thread.currentThread().getName() + "------->余额为" + getBalance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //2.同步方法解决问题
    public synchronized void draw(Double drawAmount) {
        if (balance >= drawAmount) {
            //为了演示在这个过程中另一个线程进入运行
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            setBalance(balance - drawAmount);
            System.out.println(Thread.currentThread().getName() + "========》操作成功");
            System.out.println(Thread.currentThread().getName() + "========》现余额为" + getBalance());

        } else {
            System.out.println(Thread.currentThread().getName() + "------->error：余额不足");
            System.out.println(Thread.currentThread().getName() + "------->余额为" + getBalance());
        }
    }

    public int hashcode() {
        return accoundNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {

            return true;
        }
        if (obj != null && obj.getClass() == ThreadT.Account.class) {
            ThreadT.Account target = (ThreadT.Account) obj;
            return target.getAccoundNo().equals(accoundNo);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accoundNo='" + accoundNo + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setAccoundNo(String accoundNo) {
        this.accoundNo = accoundNo;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccoundNo() {
        return accoundNo;
    }

    public Double getBalance() {
        return balance;
    }

    public Account(String accoundNo, Double balance) {
        this.accoundNo = accoundNo;
        this.balance = balance;
    }
}
