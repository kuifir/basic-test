package ThreadT.conditionT;



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
public class DrawThread extends Thread{

    private Account account;
    private Double drawAmount;

    @Override
    public void run() {
      /*  yield();*/
     /*   try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int a= 0; a <30; a++) {
            System.out.println(Thread.currentThread().getName()+"DrawThread第"+(a+1)+"次运行");
            account.draw(drawAmount);
            System.out.println(Thread.currentThread().getName()+"DrawThread第"+(a+1)+"次运行结束");
        }
    }
    public DrawThread(String name, Account account, Double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
 /*   public DrawThread(String name, Account account, Double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
        FutureTask task = new FutureTask<>((Callable) () -> {
            for (int i = 0; i <2; i++) {
                System.out.println("DrawThread运行");
                account.draw(drawAmount);
            }
            return null;
        });

        new Thread(task, name).start();
        System.out.println("是否被取消?"+task.isDone());
    }*/

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    public Account getAccount() {
        return account;
    }

    public Double getDrawAmount() {
        return drawAmount;
    }

}
