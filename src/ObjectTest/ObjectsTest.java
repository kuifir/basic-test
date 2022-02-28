package ObjectTest;

import java.util.Objects;

/**
 * Package: ObjectTest
 * <p>
 * Description： Objects工具类 大多是空指针安全的
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 17:51
 * <p>
 * Version: 0.0.1
 */
public class ObjectsTest {
    static ObjectsTest obj;
    public static void main(String[] args) {
        // 输出一个null对象的hashCode值，输出0
        System.out.println(Objects.hashCode(obj));
        // 输出一个null对象的toString，输出null
        System.out.println(Objects.toString(obj));
        // 要求obj不能为null，如果obj为null则引发异常
        System.out.println(Objects.requireNonNull(obj,"obj参数不饿能是null"));
    }
}
