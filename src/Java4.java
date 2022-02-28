import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Java4 {
    public static void main(String [] args)  {
        System.out.println(change(People.age));//25
        System.out.println(People.age);//48

    }
    public static int change(int c){
        System.out.println(c== People.age);//ture
        c=25;
        System.out.println(People.age);//5
        c=People.age;
        c=25;
        System.out.println(People.age);//5
        People.age=48;
        return c;
    }
    static class People {
        public static int age=5;

    }
}


