package FinalizeTest;

import java.lang.ref.WeakReference;

/**
 * Package: FinalizeTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 17:08
 * <p>
 * Version: 0.0.1
 */
public class ReferenceTest {
    public static void main(String[] args) {
//        创建一个人字符串
        String str =new String("Java");
        // 创建一个弱引用，让此弱引用到字符串
        WeakReference wr =new WeakReference(str);
        // 切断str引用和字符串之间的引用
        str =null;
        // 取出弱引用所引用的对象
        System.out.println(wr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        // 再次去除弱引用所用的对象
        System.out.println(wr.get());

    }
}
