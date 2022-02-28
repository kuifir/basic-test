package lambda;

/**
 * Package: lambda
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 20:35
 * <p>
 * Version: 0.0.1
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest =new LambdaTest();
        // Lambda 表达式的代码块只有一句，可以省略花括号
        lambdaTest.eat(()->
        {
            System.out.println("苹果的味道不错");
        });
        lambdaTest.eat(()-> System.out.println("苹果的味道不错"));
        // Lambda 表达式的形参列表只有一个形参，可以省略圆括号
        lambdaTest.dirver(weather -> {
            System.out.println("今天的天气是"+ weather);
            System.out.println("直升机飞行平稳");
        });
        lambdaTest.dirver(weather -> System.out.println("今天的天气是"+ weather));
        // Lambda 表达式的代码快只有一句，可以省略花括号
        // 代码块中只有一条语句，即使该表达式需要返回值，也可以省略return关键字
        lambdaTest.test((a,b)-> a+b);
    }
    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }
    public void dirver(Flyable f){
        System.out.println("我正在驾驶："+f);
        f.fly("【碧空如洗的晴日】");
    }
    public void test(Addable add){
        System.out.println("5和3的和为：" + add.add(5,3));
    }
}
interface Eatable{
    void taste();
}
interface Flyable{
    void fly(String weather);
}
interface Addable{
    int add(int a, int b);
}