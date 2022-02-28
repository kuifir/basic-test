package FinalizeTest;

import org.omg.SendingContext.RunTime;

/**
 * Package: FinalizeTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 16:44
 * <p>
 * Version: 0.0.1
 */
public class GcTest {
    public static void main(String[] args) {
        for (int i = 0; i<4; i++) {
            new GcTest();
            //下面两行代码作用完全相同
//            System.gc();
            Runtime.getRuntime().gc();
        }
    }
    public void finalize(){
        System.out.println("系统正在请理GcTest对象的资源");
    }
}
