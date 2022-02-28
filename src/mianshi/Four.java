package mianshi;

/**
 * Package: mianshi
 * <p>
 * Description： TODO
 * <p>
 * Author: 张奎
 * <p>
 * Date: Created in 2020/8/3 21:24
 * <p>
 * Version: 0.0.1
 */
public class Four {
    public static void main(String[] args) {
        int a = 10000;
        int n=0;
        for (int i=1;i<=a;i++) {
             n += new Four().find(i);
        }
        System.out.println(n);
    }

    //a为传入的数,返回值为每次增加的0的个数
    public int find(int a) {
        int b = 0;
        if (a % 5 == 0&& a!=0) {
            b++;
            b+= find(a / 5);
        }
        return b;
    }
}