package reflectTest;

import NetT.GetPostTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Package: reflectTest
 * <p>
 * Description： 获取泛型类型
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/13 0:18
 * <p>
 * Version: 0.0.1
 */
public class GenericTest {
    private Map<String,Integer> score;

    public static void main(String[] args) throws NoSuchFieldException {
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");
        // 直接使用getType()取出类型只对普通类型的成员变量有效
        Class<?> a = f.getType();
        // 下面将看到进输出java.util.Map
        System.out.println("score的类型是"+a);
        // 获得成员变量f的泛型类型
        Type gType =f.getGenericType();
        // 如果gtype类型是ParameterizedType对象
        if(gType instanceof ParameterizedType){
            // 强制类型转换
            ParameterizedType pType = (ParameterizedType) gType;
            //获取原始类型
            Type rType =pType.getRawType();
            System.out.println("原始类型是"+rType);
            // 取得泛型类型的泛型参数
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型信息是");
            for(int i = 0; i< tArgs.length;i++){
                System.out.println("第"+i+"个泛型类型是"+ tArgs[i]);
            }
        }else {
            System.out.println("获取泛型类型出错");
        }
    }
}
