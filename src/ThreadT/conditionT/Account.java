package ThreadT.conditionT;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package: ThreadT.notifyTT;
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
    // 封装庄户编号、账户余额两个变量
    private String accoundNo;
    private Double balance;
    // 显示定义Lock对象
    private final Lock lock = new ReentrantLock();
    // 获得指定Lock对象对应的condition
    private final Condition condition = lock.newCondition();
    // 标识账号是否已有存款的标志
    private boolean flag = false;
    int i = 0;
    int j = 0;

    public void draw(Double drawAmount) {
        i++;
        try {
            lock.lock();
            while (!flag) {
                System.out.println(Thread.currentThread().getName() + "========》第" + i + "次操作取钱：等待中");
                condition.await();

            }
            while (flag) {
                if (balance >= drawAmount) {
                    balance -= drawAmount;
                    System.out.print(Thread.currentThread().getName() + "========》第" + i + "次操作成功,取钱：" + drawAmount);
                    System.out.println(Thread.currentThread().getName() + "========》现余额为" + getBalance());
                    flag = false;
                    condition.signalAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void deposit(Double deposit) {
        j++;
        try {
            // 加锁
            lock.lock();
            while (flag) {
                System.out.println(Thread.currentThread().getName() + "========》第" + j + "次操作,存钱:等待中");
                condition.await();

            }
            while (!flag) {
                balance += deposit;
                System.out.println(Thread.currentThread().getName() + "========》第" + j + "次操作成功,存钱：" + deposit);
                System.out.println(Thread.currentThread().getName() + "========》现余额为" + getBalance());
                flag = true;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
/*    public int hashcode() {
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
    }*/

    public Account() {
    }

    // 构造器
    public Account(String accoundNo, Double balance) {
        this.accoundNo = accoundNo;
        this.balance = balance;
    }

    public String getAccoundNo() {
        return accoundNo;
    }

    // 因为账户余额不能随便修改，所以只为balance提供getter方法
    public Double getBalance() {
        return balance;
    }

    public void setAccoundNo(String accoundNo) {
        this.accoundNo = accoundNo;
    }
}
