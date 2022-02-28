package ThreadT.threadSynchronized.lock;

/**
 * Package: ThreadT
 * <p>
 * Description： 死锁测试所用到的类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 21:51
 * <p>
 * Version: 0.0.1
 */
public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入主线程之后");
    }

    public static void main(String[] args) {
       DeadLock dl = new DeadLock();
       new Thread(dl).start();
       dl.init();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入副线程之后");
    }
}

class A {
    public synchronized void foo(B b) {
        System.out.println("当前线程名" + Thread.currentThread().getName() + "进入了A的foo()方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名是：" + Thread.currentThread().getName() + "企图调用B的last()方法");
        b.last();
    }

    public synchronized void last() {
        System.out.println("当前线程名是：" + Thread.currentThread().getName() + "进入A的last()方法");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("当前线程名" + Thread.currentThread().getName() + "进入了B的bar()方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名是：" + Thread.currentThread().getName() + "企图调用A的last()方法");
        a.last();
    }

    public synchronized void last() {
        System.out.println("当前线程名是：" + Thread.currentThread().getName() + "进入B的last()方法");
    }
}