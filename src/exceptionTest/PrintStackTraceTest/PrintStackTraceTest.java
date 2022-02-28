package exceptionTest.PrintStackTraceTest;

/**
 * Package: exceptionTest
 * <p>
 * Description： Java异常跟踪栈
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 16:18
 * <p>
 * Version: 0.0.1
 */
public class PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }
    public static void firstMethod(){
        secondMethod();
    }
    public static void secondMethod(){
        thirdMethod();
    }
    public static void thirdMethod(){
        throw new SelfException("自定义异常信息");
    }
}
class SelfException extends RuntimeException{
    public SelfException() {
    }

    public SelfException(String message) {
        super(message);
    }
}