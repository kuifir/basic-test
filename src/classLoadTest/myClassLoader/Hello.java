package classLoadTest.myClassLoader;

/**
 * Package: classLoadTest.myClassLoader
 * <p>
 * Description： TODO 注意打包位置,和编译命令行,为了简介,去掉包引用
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 19:43
 * <p>
 * Version: 0.0.1
 */
public class Hello {
    public static void main(String[] args) {
        for (String arg: args){
            System.out.println("运行Hello的参数："+arg);
        }
    }
}
