public class java1 {
    public static void main(String[] args){
        int a=10;
        int b=20;
        Integer e=128;
        Integer d=128;
        Integer f=28;
        Integer g=28;
        Integer h=-128;
        Integer i=-128;
       People people=new People();

        people.age=1000;
        people.age2=10;
        test1(a,b);
        System.out.println(""+a+"----"+b);//10---20
        test1( people.age,people.age2);
        System.out.println(""+people.age+"----"+people.age2);//1000-10
        test2(people);
        int c=people.age;
        System.out.println(""+people.age+"----"+people.age2);//1----1
        System.out.println(c);//1
        test3(people);
        System.out.println(""+people.age3);//1000
        System.out.println(e==d);//false
        System.out.println(f==g);//ture  Integer 会缓存-128-127
        System.out.println(h==i);//ture
    }
    public static void test1(int a, int b){
        a=1;
        //System.out.println(a);
        b=2;

    }
    public static void test2(People o){
        o.age=1;
        o.age2=1;
        //System.out.println(a);


    }
    public static void test3(People o){
        o.age3=1;
        //System.out.println(a);
        People.age3=1000;


    }
    static class People {
        public static int age3;
        public int age=100;
        public int age2=200;
    }
}
