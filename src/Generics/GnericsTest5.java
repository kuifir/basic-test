package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: Generics
 * <p>
 * Description： TODO 泛型与数组
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 18:06
 * <p>
 * Version: 0.0.1
 */
public class GnericsTest5 {
    public static void main(String[] args) {
//        List<String>[] lsa =new List<String>[10];

//        List<String>[] lsa =new ArrayList[10];
//        Object[] oa = lsa;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li;
//        //下面代码引起ClassCastException
//        String s = lsa[1].get(0);

//        List<?>[] lsa =new ArrayList<?>[10];
//        Object[] oa = lsa;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li;
//        //下面代码引起ClassCastException
//        String s = (String) lsa[1].get(0);

        List<?>[] lsa =new ArrayList<?>[10];
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li;
        Object target = lsa[1].get(0);
        if(target instanceof String){

        String s = (String) lsa[1].get(0);
        }
    }
}
