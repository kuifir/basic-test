package NetT;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Package: NetT
 * <p>
 * Description： 下载工具类
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 21:25
 * <p>
 * Version: 0.0.1
 */
public class DownUtil {
    //定义下载资源的路径
    private String path;
    //下载文件保存位置
    private String targetFile;
    //下载线程数
    private int threadNum;
    //下载的线程对象
    private DownThread[] threads;
    //文件大小
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        //初始化数组
        threads = new DownThread[threadNum];
    }

    public void download() throws IOException {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        connection.setRequestProperty(
                "Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg," +
                        "application/x-shockwave-flash,application/xaml+xml," +
                        "application/vnd.ms-xpsdocument,application/x-ms-xbap," +
                        "application/x-ms-application,application/vnd.ms-excel," +
                        "application/vnd.ms-powerpoint,application/maword,*/*"
        );
        connection.setRequestProperty("Accept-Language", "zh-CN");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Accept-Encoding", "identity");
        connection.setRequestProperty("User-Agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        //文件大小
        fileSize = connection.getContentLength();
        connection.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        System.out.println(fileSize);
        file.setLength(fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++) {
            //计算每个线程下载的开始位置
            int startPos = i * currentPartSize;
            // 每个线程使用一个RandomAccessFile进行下载
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            // 定位该现成的下载位置
            currentPart.seek(startPos);
            // 创建下载线程
            threads[i] = new DownThread(startPos, currentPartSize, currentPart);
            threads[i].start();
        }

    }

    // 获取下载的完成百分比
    public double getCompleteRate() {
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += (threads[i]).length;
        }
        return sumSize * 1.0 / fileSize;
    }


    private class DownThread extends Thread {
        //当前现成的下载位置
        private int startPos;
        //定义当前线程负责下载文件的大小
        private int currentPartSize;
        //当前线程下载的文件块
        private RandomAccessFile currentPart;
        //定义该线程已经下载的字数
        public int length;

        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.setRequestProperty(
                        "Accept", "image/gif,image/jpg，image/jpeg,image/pjpeg,image/pjpeg," +
                                "application/x-shockwave-flash,application/xaml+xml," +
                                "application/vnd.ms-xpsdocument,application/x-ms-xbap," +
                                "application/x-ms-application,application/vnd.ms-excel," +
                                "application/vnd.ms-powerpoint,application/maword,*/*"
                );
                connection.setRequestProperty("Accept-Language", "zh-CN");
                connection.setRequestProperty("Accept-Encoding", "identity");
                connection.setRequestProperty("Charset", "UTF-8");
                InputStream inputStream = connection.getInputStream();
                inputStream.skip(this.startPos);
                System.out.println(this.startPos);
                byte[] buff = new byte[1024];
                int hasread = 0;

                while (length <= currentPartSize && (hasread = inputStream.read(buff)) != -1) {

                    if ((length + hasread) > currentPartSize) hasread = currentPartSize - length;
                    currentPart.write(buff, 0, hasread);
                    length += hasread;

                }
                currentPart.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }

    }
}
