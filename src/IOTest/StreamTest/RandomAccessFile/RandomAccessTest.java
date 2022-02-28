package IOTest.StreamTest.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Package: IOTest.StreamTest.RandomAccessFile
 * <p>
 * Description： RandomAccessTest可以任意访问文件位置
 * 但是只能操作文件
 * 本程序部分读取文件内容
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 10:41
 * <p>
 * Version: 0.0.1
 */
public class RandomAccessTest {
    public static void main(String[] args) {
        try (
                RandomAccessFile raf = new RandomAccessFile("src\\IOTest\\StreamTest\\RandomAccessFile\\RandomAccessTest.java", "r");
        ) {
            // 获取RamdomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置："+raf.getFilePointer());
            // 移动raf的文件记录指针的位置
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 通过循环来重复读取
            while ((hasRead = raf.read(bbuf))>0){
                System.out.println(new String(bbuf,0,hasRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
