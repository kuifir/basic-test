
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionTest {
    public static  void main(String[] args){
        Collection a=new HashSet() ;
        a.add("ssdxcvgrfddssss");
        a.add("ssvfvfres");
        a.add("ssddsahyhhyssdffasws");
        a.add("ssdds");
        a.add("sss");
        a.add("ssddsasasws");

        //===================================================================
        /*
        iterable是collection的一个父类接口，可以实现遍历
         */
        a.forEach(obj->System.out.println("a元素"+obj));

        //===
        a.forEach(new Consumer(){
            public void accept(Object o) {
                System.out.println("a元素"+o);
            }
        });
        // ===============================================================
        /*
        迭代器遍历
         */
        Iterator it=a.iterator();
       // it.forEachRemaining(obj->System.out.println("forEachRemaining-----"+obj));

        while (it.hasNext()){
            String st=(String) it.next();
            System.out.println(st);
            if (st.equals("sss")) {
                it.remove();
            }
        }
        System.out.println("删除后"+a);


    //====================================================================
    /*
    foreach遍历
     */
    for(Object ai:a){
        System.out.println("foreach---------"+ai);
    }
   //======================================
        a.removeIf(new Predicate(){

            @Override
            public boolean test(Object o) {
                return ((String)o).equals("ssdds");
            }
        });
        System.out.println("removeIf----------------"+a);










    }
}
