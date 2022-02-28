package CollectionTest.ListTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: CollectionTest.ListTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/19 10:46
 * <p>
 * Version: 0.0.1
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> books =new ArrayList<>();
        books.add(new String("Java"));
        books.add(new String("Ajax"));
        books.add(new String("Android"));
        // 将新字符串对象插入在第二个位置
        books.add(1,new String("Java ee"));
        for (int i =0;i<books.size();i++){
            System.out.println(books.get(i));
        }
        books.remove(2);
        System.out.println(books);
        // 判断指定元素在List集合中的位置：输出1，表明位于第二位
        System.out.println(books.indexOf(new String("Java")));// List判断的标准是equals方法返回true.所以用新对象也能找到
        System.out.println(books);
        // books子集第二个到第三个元素（前闭后开）截取成的子集
        System.out.println(books.subList(1,2));
    }
}
