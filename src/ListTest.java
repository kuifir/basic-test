import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List li = new ArrayList();
        li.add("dwsssssssssssssssssssssssssssssss");
        li.add("所发生的v");
        li.add("大部分啊v吧");
        System.out.println(li);
        li.sort(((o1, o2) -> {
            return ((String) o1).length()- ((String) o2).length();
        }));
        System.out.println(li);
        li.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return -1;
            }
        });
        System.out.println(li);
        li.replaceAll((ele)->{
            return ("replaceAll的使用----->"+(String)ele);
        });
        System.out.println(li);
    }
}

