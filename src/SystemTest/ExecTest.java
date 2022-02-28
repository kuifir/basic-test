package SystemTest;

import java.io.IOException;

/**
 * Package: SystemTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/16 17:13
 * <p>
 * Version: 0.0.1
 */
public class ExecTest {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        // 运行笔记本程序
        rt.exec("notepad.exe");
    }
}
