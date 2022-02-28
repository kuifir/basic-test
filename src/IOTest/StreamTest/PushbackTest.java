package IOTest.StreamTest;

import java.io.*;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： 推回输入流
 * PushbackInputStream 和PushbackReader 提供了三个推回方法
 * 这两个推回输入流都带有一个推回缓冲区，从而允许重复读取刚刚读取的内容。
 * 当程序调用这两个推回输入流的unread方法时，系统会把指定数组的内容推回缓冲区
 * 而推回输入流每次调用read()方法时总是先从退回缓冲区读取，
 * 只有完全读取了退回缓冲区的内容后，但还没有装满read()所需的数组时才会从原输入流中读取
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 15:40
 * <p>
 * Version: 0.0.1
 */
public class PushbackTest {
    public static void main(String[] args) {
        // 下面程序试图找出程序中的"new PushbackInputStream"字符串，当找到该字符串后，程序只是打印出目标字符串之前的内容
        try (
                // 创建一个PushbackInputStream对象，指定推回缓冲区的长度为64
                PushbackInputStream pbis = new PushbackInputStream(new FileInputStream(
                        "src\\IOTest\\StreamTest\\PushbackTest.java"), 132
                )) {
            byte[] buf = new byte[64];
            // 用以保存上次读取的字符串的内容
            String lastread = "";
            int hasread = 0;
            // 循环读取文件内容
            while ((hasread = pbis.read(buf)) > 0) {
                // 将读取的内容转化为字符串
                String content = new String(buf, 0, hasread);
                int targetIndex = 0;
                // 如果上次读取的内容和这次读取的内容包目标字符串
                if ((targetIndex = (lastread + content).indexOf("new PushbackInputStream")) > 0) {
                    // 将本次内容和上次内容一起退回缓冲区
                    pbis.unread((lastread + content).getBytes());

//                    targetIndex = (((lastread + content).substring(0, targetIndex)).getBytes()).length;
                    // 如果目标字符串所在下标大于每次读取数组的下标，重新定义一个大小正好到目标字符串的长度的数组
                    if (targetIndex > 64) {
                        buf = new byte[targetIndex];
                        System.out.print(targetIndex);
                    }
                    // 再次读取指定长度内容
                    pbis.read(buf, 0, targetIndex);
                    System.out.print(new String(buf,0,targetIndex));
                    System.exit(0);

                } else {
                    // 输出上次读取的内容
                    System.out.print(lastread);
                    lastread = content;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
