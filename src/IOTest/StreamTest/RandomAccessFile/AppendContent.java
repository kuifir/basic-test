package IOTest.StreamTest.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Package: IOTest.StreamTest.RandomAccessFile
 * <p>
 * Description： 向指定文件后追加内容，
 * 为了追加内容程序应该先将记录指针移动到文件最后，然后开始像文件中输出内容
 * 注意RandomAccessFile依然不能向文件的指定位置插入内容
 * 如果直接将文件记录指针移动到中间某位置开始输出，则新输出的内容会覆盖文件中原有的内容
 * 如果需要向指定位置插入内容，程序需要先把插入点后面的内容读入缓冲区，等把需要插入的数据写入文件后，
 * 再将缓冲取的内容追加到文件后面
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 10:51
 * <p>
 * Version: 0.0.1
 */
public class AppendContent {
    public static void main(String[] args) {
        try (
                // 以读、写方式打开一个RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile("out.txt", "rw");
        ) {
            // 将记录指针移动到out.txt文件的最后
            raf.seek(raf.length());
            raf.write("追加的内容！\r\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
