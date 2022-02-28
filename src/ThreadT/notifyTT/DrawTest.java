package ThreadT.notifyTT;



/**
 * Package: ThreadT.notifyTT;
 * <p>
 * Description：  事务测试使用的类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 20:12
 * <p>
 * Version: 0.0.1
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account=new Account("15485",0.0);
        new DrawThread("取钱者",account,400.00).start();
        /*new DrawThread("取钱者2",account,400.00).start();
        new DrawThread("取钱者3",account,400.00).start();*/
        DepositThread deposit1=new DepositThread("存钱者甲",account,400.00);
        DepositThread deposit2=new DepositThread("存钱者乙",account,400.00);
        DepositThread deposit3=new DepositThread("存钱者丙",account,400.00);
        deposit1.start();
        deposit2.start();
        deposit3.start();
    }
}
