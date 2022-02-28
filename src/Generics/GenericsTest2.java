package Generics;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Package: Generics
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/8 16:24
 * <p>
 * Version: 0.0.1
 */
public class GenericsTest2 {
    public static void main(String[] args) {
        TreeSet<String> ts1 =new TreeSet<>(new Comparator <Object>(){

            @Override
            public int compare(Object fst, Object snd) {
                return hashCode() > snd.hashCode() ? 1
                        : hashCode() < snd.hashCode() ? -1 : 0;
            }
        });
        ts1.add("hello");
        ts1.add("wa");
        TreeSet<String> ts2 =new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? -1
                        : o1.length()< o2.length() ? 1 : 0;
            }
        });
        ts2.add("hello");
        ts2.add("wa");
        System.out.println(ts1);
        System.out.println(ts2);
    }
}
