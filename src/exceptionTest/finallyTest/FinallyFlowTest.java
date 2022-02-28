package exceptionTest.finallyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Package: exceptionTest
 * <p>
 * Description： 不要finally块中使用如return 或 throw等导致方法总之的语句
 * 一旦在finallu块中使用可return或throw语句，将会导致try块、catch块中的return、throw语句失效
 * java执行try块catch块语句遇到return或throw语句，会先寻找是否有finally块
 * 有的话执行finally之后在返回try或catch块的return或throw
 * 如果finally也使用了return或throw，则方法终止，不会跳回去
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 13:43
 * <p>
 * Version: 0.0.1
 */
public class FinallyFlowTest {
    public static void main(String[] args) {
        boolean a =test();
        System.out.println(a);
    }
    public static boolean test(){
        try {
            // 因为finally语句包含了return语句，所以下面的return语句失去作用
            return true;
        }finally {
            return false;
        }
    }
}
