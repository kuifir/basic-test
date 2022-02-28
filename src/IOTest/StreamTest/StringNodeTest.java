package IOTest.StreamTest;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： 字符流可以使用子字符串作为物理节点
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 15:10
 * <p>
 * Version: 0.0.1
 */
public class StringNodeTest {
    public static void main(String[] args) {
        String str="dgrmmrelgmrel\n"
                +"dfvrefwefewafe\n"
                +"dfvrefwefewafe\n"
                +"dfvrefwefewafe\n"
                +"dfvrefwefewafe\n"
                ;
        char[] buff=new char[32];
        int hasread=0;

        try(StringReader sr=new StringReader(str)){
            // 循环读取字符串
            while ((hasread=sr.read(buff))>0){
                System.out.print(new String(buff,0,hasread));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try(
                // 创建StringWriter时，实际上以一个StringBuffer作为输出节点
                StringWriter sw=new StringWriter()
        ) {
            sw.write("fdnsgvilk\n");
            sw.write("fdnsgvilk\n");
            sw.write("fdnsgvilk\n");
            sw.write("fdnsgvilk\n");
            System.out.println("下面是sw字符串节点里的内容");
            System.out.println(sw.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
