package IOTest.NIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 12:53
 * <p>
 * Version: 0.0.1
 */
public class RandomFileChannelTest {
    public static void main(String[] args) {
        File f = new File("src\\IOTest\\NIO\\RandomFileChannelTest.txt");
        try (
                // 创建一个RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile(f, "rw");
                // 获取RandomAccessFile对应的channel
                FileChannel fileChannel = raf.getChannel();
        ) {
            // 将channel中的所有数据映射成ByteBuffer
            ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            // 把Channel的记录指针移到最后
            fileChannel.position(f.length());
            // 将bugger中的所有数据输出
            fileChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
