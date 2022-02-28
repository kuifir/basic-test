package RandomTest;

import java.util.Arrays;
import java.util.Random;

/**
 * Package: RandomTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 10:47
 * <p>
 * Version: 0.0.1
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random =new Random();
        System.out.println("random.nextBoolean():"+random.nextBoolean());
        byte[] buffer =new byte[16];
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        // 生成0.0-1.0之间伪随机double数
        System.out.println("random.nextDouble():"+random.nextDouble());
        // 生成0.0-1.0之间的伪随机nextFloat
        System.out.println("random.nextFloat():"+random.nextFloat());
        // 生成平均值是0.0，标准差是1.0的伪高斯数
        System.out.println("random.nextGaussian():"+random.nextGaussian());
        // 生成一个处于int整数取值范围的伪随机数
        System.out.println("random.nextInt():"+random.nextInt());
        // 生成一个处于0-26整数取值范围的伪随机数
        System.out.println("random.nextInt(26):"+random.nextInt(26));

    }
}
