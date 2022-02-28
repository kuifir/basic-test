package BigdecimalTest;

import java.math.BigDecimal;

/**
 * Package: BigdecimalTest
 * <p>
 * Description： double加减乘除工具类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 11:25
 * <p>
 * Version: 0.0.1
 */
public class Airth {
    public static void main(String[] args) {
        System.out.println("0.05+0.01="+(Airth.add(0.05,0.01)));
        System.out.println("1.0-0.42="+Airth.subtract(0.05,0.01));
        System.out.println("4.015*100="+Airth.multiply(4.015,100));
        System.out.println("123.3/100="+Airth.divide(123.3,100));
    }
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    // 构造器私有，不能实例化
    private Airth(){

    }
    // 提供精确的加法运算
    public static double add(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }
    // 提供精确的减法运算
    public static double subtract(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }
    // 提供精确的乘法运算
    public static double multiply(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }
    // 提供（相对）精确的除法运算，当发生除不尽的情况时精确到小数点以后10位的数字四舍五入
    public static double divide(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
