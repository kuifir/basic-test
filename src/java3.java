import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class java3 {

    public static void main(String [] args) throws UnsupportedEncodingException {

        Integer a=new Integer(35);
        int b=35;
       // b=b+1444848747544L;
        Integer c=new Integer(35);
        System.out.println(a==b);
        System.out.println(a==c);

        String s="等xsdedfedsfefgergte等";
       // byte[] x=s.getBytes("GB2312");
        System.out.println( s.replace("等","哈"));
        System.out.println( s+ s.length()+ Arrays.toString(s.getBytes("GB2312")) +s.charAt(4));

        Boolean boo = new Boolean(false);
        System.out.println(boo&&true);
    }
}


