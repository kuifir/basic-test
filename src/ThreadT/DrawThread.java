package ThreadT;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Package: ThreadT
 * <p>
 * Description： 事务测试使用的类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 19:21
 * <p>
 * Version: 0.0.1
 */
public class DrawThread {

    private ThreadT.Account account;
    private Double drawAmount;
    public DrawThread(String name, ThreadT.Account account, Double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
        FutureTask task=new FutureTask<>((Callable)()->{
            //3.ReenreantLock显式加锁解锁同步锁
            account.draw3(drawAmount);
            //2.同步方法解决问题，在Account中创建好同步方法，在这里直接引用
          /*  account.draw(drawAmount);*/
            //1.同步代码块，解决并发问题
          /*  synchronized (account) {
                if (account.getBalance() >= drawAmount) {
                    //为了演示在这个过程中另一个线程进入运行
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                    account.setBalance(account.getBalance() - drawAmount);
                    System.out.println(Thread.currentThread().getName()+"========》操作成功");
                    System.out.println(Thread.currentThread().getName()+"========》现余额为" + account.getBalance());

                } else {
                    System.out.println(Thread.currentThread().getName()+"------->error：余额不足");
                    System.out.println(Thread.currentThread().getName()+"------->余额为" + account.getBalance());
                }
            }*/
            return null;
        });
        new Thread(task,name).start();
    }
    @Override
    public String toString() {
        return "DrawThread{" +
                "account=" + account +
                ", drawAmount=" + drawAmount +
                '}';
    }

    public void setAccount(ThreadT.Account account) {
        this.account = account;
    }

    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    public ThreadT.Account getAccount() {
        return account;
    }

    public Double getDrawAmount() {
        return drawAmount;
    }

}
