import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 13:22
 * <p>
 * Version: 0.0.1
 */
public class FileLockTest {
    public static void main(String[] args) {
        try {
            FileChannel fileChannel=new FileOutputStream("FileLockTest.txt").getChannel();
            FileLock fileLock=fileChannel.tryLock();
            Thread.sleep(1000);
            fileLock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
