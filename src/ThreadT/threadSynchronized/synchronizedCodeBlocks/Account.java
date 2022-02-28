package ThreadT.threadSynchronized.synchronizedCodeBlocks;

import java.util.Objects;

/**
 * Package: ThreadT.threadSynchronized.AccountQuestion
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/24 18:15
 * <p>
 * Version: 0.0.1
 */
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

    public void setBalance(double balance) {
        this.balance = balance;
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
