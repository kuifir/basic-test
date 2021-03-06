package IOTest.NIO2.FilesTest;

import java.io.IOException;
import java.nio.file.*;

/**
 * Package: IOTest.NIO2.FilesTest
 * <p>
 * Description： 监听桌面文件变化
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 20:01
 * <p>
 * Version: 0.0.1
 */
public class WatchKeyServiceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 获取文件系统的WatchService对象
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // 为C:盘根路径注册监听
        Paths.get("C:\\Users\\myfir\\Desktop").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE
                );
        while (true){
            // 获取下一个文件变化事件
            WatchKey key =watchService.take();
            for (WatchEvent<?> event : key.pollEvents()){
                System.out.println(event.context()+"文件发生了"+event.kind()+"事件！");

            }
            // 重设WatchKey
            boolean valid = key.reset();
            // 如果重设失败，推出监听
            if (!valid){
                break;
            }
        }
    }
}
