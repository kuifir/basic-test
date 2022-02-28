package NetT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Package: NetT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 11:01
 * <p>
 * Version: 0.0.1
 */
public class GetPostTest {
    public static void main(String[] args) {
        String s=GetPostTest.sendGet("https://www.zhipin.com/","ka=header-home");
        System.out.println(s);
        String s1=GetPostTest.sendPost("https://www.zhipin.com","?ka=header-home");
        System.out.println(s1);

    }

    /**
     * 向指定URL发送GET方式的请求
     * @param url 发送请求的URL
     * @param param 请求参数 格式满足name1 = value&name2=value2的形式
     * @return URL代表远程资源的响应
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL url1 = new URL(urlName);
            // 打开和URL之间的连接
            URLConnection urlConnection = url1.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
            // 建立实际的链接
            urlConnection.connect();
            // 获取所有的响应头字段
            Map<String, List<String>> map = urlConnection.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "=====>" + map.get(key));
            }
            try (
                    // 定义BufferedReader输入流来读取URL的响应
                    BufferedReader in =
                         new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),
                                 "utf-8"));) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("发送Get请求出现异常：" + e);
            e.printStackTrace();
        }

        return result;

    }

    /**
     * 向指定URL发送POST方式的请求
     * @param url 发送请求的URL
     * @param param 请求参数 格式满足name1=value&name2=value2的形式
     * @return URL代表远程资源的响应
     */
    public static String sendPost(String url, String param) {
        String result = "";
        try {
            URL url1 = new URL(url);
            // 打开和URL之间的连接
            URLConnection urlConnection = url1.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
            // 发送POST必须设置如下两行
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            try (
                    // 获取URLConnection对象对应的输出流
                    PrintWriter out = new PrintWriter(urlConnection.getOutputStream());) {
                // 发送请求参数
                out.print(param);
                // flush输出流的缓冲
                out.flush();
            }
            try (
                    // 定义BufferedReader输入流来读取URL的响应
                    BufferedReader in =
                         new BufferedReader(new InputStreamReader(urlConnection.getInputStream()
                                 , "utf-8"));)
            {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("发送Post请求出现异常：" + e);
            e.printStackTrace();
        }

        return result;

    }

}
