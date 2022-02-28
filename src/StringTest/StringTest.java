package StringTest;

import java.util.Scanner;
import java.util.SplittableRandom;

/**
 * Package: StringTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 21:58
 * <p>
 * Version: 0.0.1
 */
public class StringTest {
    public static void main(String[] args) {
        // char charAt(int index) 获取字符串中指定位置的字符
        String s = new String("dadeaadsfa");
        System.out.println("s.charAt(5): "+s.charAt(5));

        // int compareTo（String anotherString）:比较两个字符串的大小。
        // 如果两个字符串序列星等，则返回0
        // 不相等时，从两个字符串的第0个字符开始比较，返回第一个不相等的字符差。
        // 另一种情况，较长字符串的前面部分恰好是较短的字符串，则返回他们的长度差
        String s1 = new String("abcdefghijklmn");
        String s2 = new String("abcdefg");
        String s3 = new String("abcdefghijalmn");
        String s4 = new String("abcdefghijklmn");
        System.out.println("s1.compareTo(0s2):"+s1.compareTo(s2));// 返回长度差
        System.out.println("s1.compareTo(s3):"+s1.compareTo(s3));// 返回'k'-'a'
        System.out.println("s1.compareTo(s4):"+s1.compareTo(s4));// 返回 0

        // String concat(String str) :将该String对象与str连接在一起。与"+"的功能相同
        // boolean contentEquals(StringBuffer sb)：将该String对象与StringBuffer对象sb进行比较，当他们包含的字符序列相同返回true
        // static String copyValueOf(char[] data): 将字符数组连缀成字符串，与String(char[] content)构造器的功能相同
        // boolean endsWith(String suffx): 返回该String对象是否以suffix结尾
        String s5 = "abcdefghijklmn";
        String s6 = "lmn";
        StringBuffer sb7 = new StringBuffer("abcdefghijklmn");
        System.out.println("s5.concat(s6):"+s5.concat(s6));
        System.out.println("s5.contentEquals(sb7):"+s5.contentEquals(sb7));
        System.out.println("String.copyValueOf((s5.toCharArray())):"+String.copyValueOf((s5.toCharArray())));
        System.out.println("s5.endsWith(s6):"+s5.endsWith(s6));

        // boolean equals(Object anObject):将该字符串与指定兑现个比较，如果两者包含的字符序列相等，则返回true
        // boolean equalsIgnoreCase(String str): 遇上一个方法类似，只是忽略大小写
        // byte getbytes()将该String对象转换成byte数组
        // void getChars(int srcBegin,int srcEnd, char[] dst,int dstBegin): 该方法将字符串从srcBegin开始，到srcEnd结束的字符复制带dst字符数组中，其中disBegin为目标字符数组的起始复制位置
        System.out.println( String.join("\' , \'",s5.split("")));
        char [] chars ={'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 'k' , 'l' , 'm' , 'n'};
        String s7 = new String("ejb");
        s7.getChars(0,3,chars,7);
        System.out.println(chars);

        // int indexOf(int ch):找出ch字符在该字符串中第一次出现的位置。
        // int indexOf(int ch, int fromIndex):找出ch在该字符串中从fromIndex开始后第一次出现的位置
        // int indexOf(String str):找出str 子字符串在该字符串中第一次出现的位置
        // int indexOf(String str, int fromIndex) 找出str 子字符串在该字符串中从fromIndex开始后第一次出现的位置
        String s8 = "abcdefgede";
        String s9 = "de";
        System.out.println("s8.indexOf('d'):"+s8.indexOf('d'));
        System.out.println("s8.indexOf('d',5):"+s8.indexOf('d',5));
        System.out.println("s8.indexOf(s9,5):"+s8.indexOf(s9,5));
        System.out.println(s8.replace('d','3'));
    }
}
