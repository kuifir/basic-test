package mianshi;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Package: mianshi
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/3 22:06
 * <p>
 * Version: 0.0.1
 */
public class Three {
    //队列获取，获取第一个元素，栈获取最后一个元素。本类主要是模拟过程，没有完善出错的处理。
    public static void main(String[] args) {
        String[] strings = new String[]{"ss", "sww", "aa", "dd"};
        Three three = new Three(strings);
        System.out.println(three.getelem("QUEUE"));
        System.out.println(three.getelem("STACK"));

    }

    private int length = 10;
    private Object[] obj;

    public Three(int length) {
        this.length = length;
        this.obj = new Object[length];
    }

    public Three(Object[] obj) {
        this.length = obj.length;
        this.obj = obj;
    }

    public Object getelem(String method) {
        if (method.equals("QUEUE")) {
            Object o = obj[0];
            this.obj = Arrays.copyOfRange(obj, 1, obj.length);
            for (Object o1:obj) {
                System.out.print(o1);
            }
            System.out.println("");

            return o;
        } else {
            Object o = obj[obj.length - 1];
            this.obj = Arrays.copyOfRange(obj, 0, obj.length-1);
            for (Object o1:obj) {
                System.out.print(o1);
            }
            System.out.println("");
            return o;
        }
    }
}
