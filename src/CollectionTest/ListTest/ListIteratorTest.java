package CollectionTest.ListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Package: CollectionTest.ListTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/19 11:33
 * <p>
 * Version: 0.0.1
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {"Java", "Ajax", "Android", "Ios",};
        List<String> bookList =new ArrayList<>();
        for(int i=0;i<books.length;i++){
            bookList.add(books[i]);
        }
        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
            lit.add("---分隔符---");
        }
        System.out.println("下面开始反向迭代");
        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}
