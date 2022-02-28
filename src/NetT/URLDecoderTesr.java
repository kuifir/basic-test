package NetT;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Package: NetT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 20:56
 * <p>
 * Version: 0.0.1
 */
public class URLDecoderTesr {
    public static void main(String[] args) {
        try {
            String keyword=  URLDecoder.decode("%E9%9B%95%E5%88%BB%E6%89%8B%E6%B3%95","utf-8");
            System.out.println(keyword);
            String urlStr= URLEncoder.encode("雕刻手法","utf-8");
            System.out.println(urlStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
