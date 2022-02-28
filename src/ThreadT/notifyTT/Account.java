package ThreadT.notifyTT;


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
    // 封装账户编号、账户余额的两个成员变量
    private String accoundNo;
    private Double balance;
    // 标识账户中是否已有存款的旗标
    private boolean flag = false;
    private int i = 0;
    private int j = 0;
    // 账户余额不允许随意修改，所以只为balance提供getter方法
    public synchronized void draw(Double drawAmount) {
        try {

            i++;
            while (!flag) {
                System.out.println(Thread.currentThread().getName() + "========》第" + i + "次操作取钱：等待中");
                this.wait();
            }
            while (flag) {//使用if（）会导致次数不对因为唤醒后，flag可能被改多次，直接跳过循环


                    balance -= drawAmount;
                    System.out.print(Thread.currentThread().getName() + "========》第" + i + "次操作成功,取钱：" + drawAmount);
                    System.out.println(Thread.currentThread().getName() + "========》现余额为" + getBalance());
                    flag = false;
                    this.notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(Double deposit) {
        try {
            j++;

            while (flag) {
                  System.out.println(Thread.currentThread().getName() + "========》存钱第" + j + "次操作,存钱:等待中");
               this.wait();
            }
            while (!flag) {
                balance += deposit;
                System.out.print(Thread.currentThread().getName() + "========》第" + j + "次操作成功,存钱：" + deposit);
                System.out.println(Thread.currentThread().getName() + "========》现余额为" + getBalance());
                flag = true;
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public Account() {
    }
    // 构造器
    public Account(String accoundNo, Double balance) {
        this.accoundNo = accoundNo;
        this.balance = balance;
    }
  /*  public int hashcode() {
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
    public String getAccoundNo() {
        return accoundNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setAccoundNo(String accoundNo) {
        this.accoundNo = accoundNo;
    }
}
