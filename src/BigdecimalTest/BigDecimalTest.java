package BigdecimalTest;

import java.math.BigDecimal;

/**
 * Package: BigdecimalTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 11:08
 * <p>
 * Version: 0.0.1
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println("0.05+0.01="+(0.05+0.01));
        System.out.println("1.0-0.42="+(1.0-0.42));
        System.out.println("4.015*100="+(4.015*100));
        System.out.println("123.3/100="+(123.3/100));

        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 = BigDecimal.valueOf(0.01);
        BigDecimal f3 = new BigDecimal(0.05);

        System.out.println("使用String作为BigDecimal构造参数================");
        System.out.println("0.05+0.01="+f1.add(f2));
        System.out.println("0.05-0.01="+f1.subtract(f2));
        System.out.println("0.05*0.01="+f1.multiply(f2));
        System.out.println("0.05/0.01="+f1.divide(f2));
        System.out.println("使用double作为BigDecimal构造参数================");
        System.out.println("0.05+0.01="+f3.add(f2));
        System.out.println("0.05-0.01="+f3.subtract(f2));
        System.out.println("0.05*0.01="+f3.multiply(f2));
        System.out.println("0.05/0.01="+f3.divide(f2));

    }
}
