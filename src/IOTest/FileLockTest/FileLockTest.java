package IOTest.FileLockTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Package: IOTest.FileLockTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 17:37
 * <p>
 * Version: 0.0.1
 */
public class FileLockTest {
    public static void main(String[] args) {
        try (
                // 使用FileOutputStream获取FileChannel
                FileChannel channel = new FileOutputStream("a.txt").getChannel();
        ) {
            // 使用非阻塞式方式对指定文件加锁
            FileLock lock =channel.tryLock();
            // 程序暂停10s
            Thread.sleep(10000);
            // 释放锁
            lock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
