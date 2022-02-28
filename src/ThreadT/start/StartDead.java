package ThreadT.start;

/**
 * Package: ThreadT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 17:30
 * <p>
 * Version: 0.0.1
 */
public class StartDead extends Thread {
    private int i;
    @Override
    public void run() {
        for (; i < 30; i++) {
            System.out.println(getName() + "=====>" + i);
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        StartDead sd=new StartDead();
        for ( int i=0;i<50;i++){
            // 调用Thread的currentThread（）方法获取当前线程
            System.out.println(Thread.currentThread().getName()+"=================="+i);

                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (i==20){
                // 启动线程
                sd.start();//
                // 判断启动后线程的isAlive()的值，输出true
                System.out.println(sd.isAlive());
            }
            // 当线程处于新建、死亡两种状态时，isAlive()返回false
            // i>20时该线程肯定已经启动过了。如果isAlive（）为假时
            // 那就是死亡状态了
            if (i>20 && !sd.isAlive()){
                System.out.println(sd.isAlive());
                sd.start();//不能对已经死去的进程使用start（）,也不要对新建的的线程使用两次
            }
        }

    }
}
