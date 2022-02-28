import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
       /* treeSet.add(5);
        treeSet.add(56);
        treeSet.add(15);
        treeSet.add(-35);*/
        // treeSet.add("ss");
        //会在插入后进行比较，方法compareTo()实现的comparable接口，插入的第一个元素无需实现
        //compareTo()比较的时候要求类型一样，所以只能插入像同类相的元素
        //相等的元素无法插入
        //自定义可变类要实现接口。判断相等标准是compareTo()返回值是否等于0
        System.out.println(treeSet);
        //======================================================================================
        treeSet.add(new R(5));
        treeSet.add(new R(-3));
        treeSet.add(new R(9));
        treeSet.add(new R(-2));
        System.out.println(treeSet);
        R first = (R) treeSet.first();
        first.cont = 20;
        R last = (R) treeSet.last();
        last.cont = -2;
        System.out.println(treeSet);
        System.out.println(treeSet.remove(new R(-2)));
        System.out.println(treeSet);
        System.out.println(treeSet.remove(new R(5)));
        System.out.println(treeSet);
        //-------------------------------------------------------------
        /*
        自定义排序
         */
        TreeSet t = new TreeSet((o1, o2) -> {
            M m1 = (M) o1;
            M m2 = (M) o2;
            return m1.age > m2.age ? 1 :
                    m1.age < m2.age ? -1 : 0;
        });
        t.add(new M(4));
        t.add(new M(24));
        t.add(new M(56));
        t.add(new M(41));
        System.out.println(t);
    }

}

//将计算compareTo中关键字设为成员变量的危害
class R implements Comparable {

    int cont;

    public R(int cont) {
        this.cont = cont;
    }

    @Override
    public String toString() {
        return "R{" +
                "cont=" + cont +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() != R.class) {
            R r = (R) obj;
            return r.cont == this.cont;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        R r = (R) o;
        return cont > r.cont ? 1 :
                cont < r.cont ? -1 : 0;
    }
}

//自定义排序
class M {
    int age;

    @Override
    public String toString() {
        return "M{" +
                "age=" + age +
                '}';
    }

    public M(int age) {
        this.age = age;
    }

}