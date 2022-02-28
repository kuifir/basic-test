import java.util.HashSet;
class A{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class B{
    @Override
    public int hashCode() {
        return 1;
    }
}
class C{
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}

public class SetTest {
    public static void main(String[] args){
        A a=new A();
        B b=new B();
        C c=new C();
        HashSet set=new HashSet();
        set.add(new A());
        set.add(new A());
        set.add(new B());
        set.add(new B());
        set.add(new C());
        set.add(new C());
        System.out.println(set);

    }
}
