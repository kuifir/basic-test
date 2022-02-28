package ThreadT.ThreadLocal;

/**
 * Package: ThreadT
 * <p>
 * Description： ThreadLocal
 * 为每一个使用该变量的线程都提供一个变量值的副本
 * 使每一个线程都可以独立的改变自己的副本，而不会和其他线程的副本冲突
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 16:44
 * <p>
 * Version: 0.0.1
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        // 启动两个线程，两个线程共享一个Account
        Account account = new Account("初始");
        // 虽然两个线程共享同一个账户，即只有一个账户名
        // 但由于账户名时ThreadLocal类型的，
        // 所以每个线程都完全拥有各自的账户名副本，因此在i=6时
        // 将看到两个线程访问同一个账户时没出现不同的账户名
        new MyTest(account,"第一个").start();
        new MyTest(account,"第二个").start();
    }
}

class Account {
    // 定义一个ThreadLocal类型的变量，该变量是一个局部线程变量
    private ThreadLocal<String> name = new ThreadLocal<>();
    // 定义一个初始化name成员变量的构造器
    public Account(String name) {
        this.name.set(name);
        // 用于访问当前线程的name副本的值
        System.out.println("-----" + this.name.get());
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }
}

class MyTest extends Thread {
    // 定义一个Account类型的成员变量
    private Account account;

    public MyTest(Account account, String name) {
        super(name);
        this.account = account;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 当i== 6的时候将账户名替换成当前线程名
            if (i == 6) {
                account.setName(getName());

            }
            // 输出同一个账户的账户名和循环变量
            System.out.println(account.getName() + "----" + i);
        }
    }
}