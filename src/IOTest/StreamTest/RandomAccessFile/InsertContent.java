package IOTest.StreamTest.RandomAccessFile;

// 插入的内容

// 插入的内容

import java.io.*;

/**
 * Package: IOTest.StreamTest.RandomAccessFile
 * <p>
 * Description： RandomAccessFile依然不能向文件的指定位置插入内容
 * 如果直接将文件记录指针移动到中间某位置开始输出，则新输出的内容会覆盖文件中原有的内容
 * 如果需要向指定位置插入内容，程序需要先把插入点后面的内容读入缓冲区，等把需要插入的数据写入文件后，
 * 再将缓冲取的内容追加到文件后面
 * 下面程序实现了向指定文件、指定位置插入内容的功能
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/23 11:20
 * <p>
 * Version: 0.0.1
 */
public class InsertContent {
    public static void main(String[] args) throws IOException {
        insert("src\\IOTest\\StreamTest\\RandomAccessFile\\InsertContent.java",45,"\n\r// 插入的内容\n\r");
    }

    public static void insert(String filename, long pos, String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try (
                RandomAccessFile raf = new RandomAccessFile(filename, "rw");
                // 使用临时文件来保存插入点后的数据
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn = new FileInputStream(tmp);
        ) {
            raf.seek(pos);
            // 下面代码将插入点后的雷龙读入临时文件中保存
            byte[] bbuf =new byte[64];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 循环读取插入点后的数据
            while ((hasRead = raf.read(bbuf))>0){
                // 将读取的数据写入临时文件
                tmpOut.write(bbuf,0,hasRead);
            }
            // 下面代码用于插入内容
            // 把文件记录指针重新定位到pos位置
            raf.seek(pos);
            // 追加需要插入的内容
            raf.write(insertContent.getBytes());
            // 追加临时文件中的内容
            while ((hasRead=tmpIn.read(bbuf))>0){
                raf.write(bbuf,0,hasRead);
            }
        }
    }
}
