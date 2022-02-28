package ThreadT;

/**
 * Package: ThreadT
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
        ThreadT.Account account=new ThreadT.Account("15485",1000.00);
        new DrawThread("甲---->",account,400.00);
        new DrawThread("乙====>",account,400.00);
        new DrawThread("丙---->",account,400.00);
        new DrawThread("丁====>",account,400.00);

    }
}
