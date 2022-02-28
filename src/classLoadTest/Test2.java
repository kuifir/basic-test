package classLoadTest;

/**
 * Package: classLoadTest
 * <p>
 * Description： 初始化块，静态初始化块，构造器，父类初始化块，父类静态初始化块，付类构造器顺序
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 15:43
 * <p>
 * Version: 0.0.1
 */
class Root{
    static {
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }

    public Root() {
        System.out.println("Root的无参数的构造器");
    }
}
class Mid extends Root{
    static {
        System.out.println("Mid的静态初始化块");
    }
    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid() {
        System.out.println("Mid的无参数的构造器");
    }
    public Mid(String msg) {
        this();
        System.out.println("Mid的有参数的构造器,参数值是："+ msg);
    }
}
class Leaf extends Mid{
    static {
        System.out.println("Leaf的静态初始化块");
    }
    {
        System.out.println("Leaf的普通初始化块");
    }

    public Leaf() {
        super("啊啊啊啊");
        System.out.println("执行Leaf的构造器");
    }
}
public class Test2 {
    public static void main(String[] args) {
        new Leaf();
        new Leaf();
    }
}
