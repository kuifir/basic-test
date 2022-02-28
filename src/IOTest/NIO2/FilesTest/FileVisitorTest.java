package IOTest.NIO2.FilesTest;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Package: IOTest.NIO2.FilesTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 19:47
 * <p>
 * Version: 0.0.1
 */
public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
        // 遍历目标目录下所有文件和子目录
        Files.walkFileTree(Paths.get("src"),new SimpleFileVisitor<Path>(){
            // 访问文件时触发该方法
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问"+file+"文件");
                // 找到了FileVisitorTest.java文件
                if(file.endsWith("FileVisitorTest.java")){
                    System.out.println("已经找到目标文件");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
            // 开始访问目录时触发该方法
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问"+dir+"路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
