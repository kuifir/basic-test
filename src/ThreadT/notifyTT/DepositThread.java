package ThreadT.notifyTT;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

/**
 * Package:ThreadT.notifyTT;
 * <p>
 * Description： 事务测试使用的类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 19:21
 * <p>
 * Version: 0.0.1
 */
public class DepositThread extends Thread{

    private Account account;
    private Double depositAmount;
    @Override
    public void run() {
        for (int b = 0; b <10; b++) {
            System.out.println(Thread.currentThread().getName()+"DepositThread第"+(b+1)+"次运行");
            account.deposit(depositAmount);
            System.out.println(Thread.currentThread().getName()+"DepositThread第"+(b+1)+"次运行结束");
        }
    }
    public DepositThread(String name, Account account, Double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }
   /* public DepositThread(String name, Account account, Double depositAmount) {
        this.account = account;
        this.depositAmount = depositAmount;
        FutureTask task=new FutureTask<>((Callable)()->{
            for (int i = 0; i < 1; i++) {
                System.out.println("DepositThread运行");
                account.deposit(depositAmount);
            }
            return null;
        });

        new Thread(task,name).start();
        System.out.println("是否被取消"+task.isDone());
    }*/


    public void setAccount(Account account) {
        this.account = account;
    }

    public void setDrawAmount(Double drawAmount) {
        this.depositAmount = drawAmount;
    }

    public Account getAccount() {
        return account;
    }

    public Double getDrawAmount() {
        return depositAmount;
    }

}
