package RandomTest;

import java.util.Random;

/**
 * Package: RandomTest
 * <p>
 * Description： 两个Random对象种子相同时，对他们以同样的顺序调用方法，会产生相同的数字序列
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 11:00
 * <p>
 * Version: 0.0.1
 */
public class SeedTest {
    public static void main(String[] args) {
        Random r1 = new Random(50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r1.nextBoolean():"+r1.nextBoolean());
        System.out.println("r1.nextInt():"+r1.nextInt());
        System.out.println("r1.nextDouble():"+r1.nextDouble());
        System.out.println("r1.nextGaussian():"+r1.nextGaussian());


        Random r2 = new Random(50);
        System.out.println("第二个种子为50的Random对象");
        System.out.println("r2.nextBoolean():"+r2.nextBoolean());
        System.out.println("r2.nextInt():"+r2.nextInt());
        System.out.println("r2.nextDouble():"+r2.nextDouble());
        System.out.println("r2.nextGaussian():"+r2.nextGaussian());
    }
}
