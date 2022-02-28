package CollectionTest.ListTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Package: CollectionTest.ListTest
 * <p>
 * Description： sort()和replaceAll（）
 * Sort需要一个Comparator对象来控制元素排序
 * replaceAll需要一个UnaryOperator来替换所有集合元素
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/19 11:17
 * <p>
 * Version: 0.0.1
 */
public class ListTest3 {
    public static void main(String[] args) {
        List<String> books =new ArrayList<>();
        // 向books添加4个元素
        books.add(new String("Java"));
        books.add(new String("Ajax"));
        books.add(new String("Android"));
        books.add(new String("Ios"));
        // 使用目标类型为Comparator的Lambda表达式对List集合排序
//        books.sort((o1,o2)->o1.length()-o2.length());
        books.sort(Comparator.comparingInt(String::length));
        System.out.println(books);
        // 使用目标类型为UnaryOperator的Lambda表达式来替换集合中的所有元素
        // 该lambda表达式控制使用每个字符串长度作为新的集合元素
         books.replaceAll(ele -> String.valueOf(ele.length()));
         System.out.println(books);

    }

}
