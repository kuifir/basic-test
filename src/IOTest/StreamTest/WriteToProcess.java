//package IOTest.StreamTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 在终端运行成功
 * 通过Process的getOutputStream（）方法获得向进程输入数据的流
 */
// 在java程序中启动java虚拟机运行另一个java程序，并向另一个Java程序输入数据
public class WriteToProcess {
    public static void main(String[] args) throws IOException {

        // 运行java ReaStandard命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("java IOTest.StreamTest.ReadStand");
//        Process p = Runtime.getRuntime().exec("java ReadStand");
        try (
                // 以p进程的输出流创建PrintStream对象
                // 这个输出流对本程序是输出流，对p进程是输入流
                PrintStream ps = new PrintStream(p.getOutputStream())
        ) {
            // 向ReadStand程序写入内容，这些内容被ReadStand读取
            ps.println("IOTest.StreamTest.WriteToProcess Words");
            ps.println(new WriteToProcess());
        }

    }
}

class ReadStand {
    public static void main(String[] args) {
        try (
                // 使用System.in创建Scanner对象，用于获取标准输入
                Scanner sc = new Scanner(System.in);
                PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
        ) {
            sc.useDelimiter("\n");
            ps.println("键盘输入的内容为---");
            while (sc.hasNext()) {
                ps.println("键盘输入的内容为---" + sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}