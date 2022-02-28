package reflectTest;

import java.lang.reflect.Array;

/**
 * Package: reflectTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/12 22:22
 * <p>
 * Version: 0.0.1
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        /*创建一个三维数组 * */
        Object arr = Array.newInstance(String.class,3,4,10);
        // 获取arr数组中index为2的元素，该元素应该是二维数组
        Object arrObj = Array.get(arr,2);
        // 使用Array为二位数组的数组元素赋值，二维数组的元素数一维数组
        // 所以传入Array的set()方法的第三个参数是一维数组
        Array.set(arrObj,2,new String[] {
                "啊啊啊",
                "包版本"
        });
        // 获取arrObj数组中index为3的元素，该元素应该是一维数组
        Object anArr =Array.get(arrObj,3);
        Array.set(anArr,8 ,"踩踩踩踩踩");
        // 将arr强制类型转换为三维数组
        String[][][] cast = (String[][][]) arr;
        // 获取cast三围数组中指定元素的值
        System.out.println(cast[2][3][8]);
        System.out.println(cast[2][2][0]);
        System.out.println(cast[2][2][1]);
    }
}
