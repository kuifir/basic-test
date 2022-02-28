package lambda;

/**
 * Package: lambda
 * <p>
 * Description： TODO Lambda 的结果被当成对象，因此可以用来赋值
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/9 10:13
 * <p>
 * Version: 0.0.1
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        Runnable r = ()->{
            for (int i=0; i<100; i++){
                System.out.println(i);
            }
        };
        r.run();
    }
}
