package exceptionTest.throwTest;

/**
 * Package: exceptionTest.throwTest
 * <p>
 * Description：
 * 如果trow抛出的是Checked异常，则该throw要么在try...catch里显示捕获该异常，
 * 要么放在一个带throws声明抛出的方法中
 * 如果抛出的是Runtime异常则无需上面操作，程序既可以try...catch捕获处理，也可以不理会该异常，交给给调用者处理
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 14:43
 * <p>
 * Version: 0.0.1
 */
public class ThrowTest {
    public static void main(String[] args) {
        try {
            throwChecked(-3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throwRuntime(3);
    }
    public static void throwChecked(int a) throws Exception {
        if(a>0){
            // 自行抛出Exception异常
            // 改代码块必须处于try块里，或处于throws声明的方法中
            throw new Exception("a的值大于0，不符合要求");
        }
    }
    public static void throwRuntime(int a){
        if (a>0){
            // 自行抛出RuntimeException异常，既可以显示捕获该异常
            // 也可以完全不理会该异常，把该异常交给方法调用者处理
            throw new RuntimeException("a的值大于0，不符合要求");
        }
    }
}
