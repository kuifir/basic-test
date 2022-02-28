package exceptionTest.PrintStackTraceTest;

/**
 * Package: exceptionTest.PrintStackTraceTest
 * <p>
 * Description： 多线程异常跟踪栈
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 16:34
 * <p>
 * Version: 0.0.1
 */
public class ThreadExceptionTest implements Runnable{

    @Override
    public void run() {
        firstMethod();
    }
    public void firstMethod(){
        secondMethod();
    }
    public void secondMethod(){
        int a =5;
        int b=0;
        int c =a/b;
    }

    public static void main(String[] args) {
        new Thread(new ThreadExceptionTest()).start();
    }
}
