package enumTest;

/**
 * Package: enumTest
 * <p>
 * Description： TODO 带抽象方法的枚举类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 15:39
 * <p>
 * Version: 0.0.1
 */
public enum EnumTest2 {
    PLUS{
        public  double eval(double x, double y){
            return x+y;
        }
    },
    MINUS{
        public  double eval(double x, double y){
            return x-y;
        }
    },
    TIMES{
        public  double eval(double x, double y){
            return x*y;
        }
    },
    DIVIDE{
        public  double eval(double x, double y){
            return x/y;
        }
    };
    // 为枚举类定义一个抽象方法
    // 这个抽象方法有不同的枚举值提供不同的实现
    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(EnumTest2.PLUS.eval(3,4));
        System.out.println(EnumTest2.MINUS.eval(3,4));
        System.out.println(EnumTest2.TIMES.eval(3,4));
        System.out.println(EnumTest2.DIVIDE.eval(3,4));
    }
}
