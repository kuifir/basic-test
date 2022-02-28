package NetT;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Package: NetT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 20:44
 * <p>
 * Version: 0.0.1
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            // 根据主机名来获取对应的InetAddress实例
            InetAddress ip=InetAddress.getByName("www.crazyit.com");
            // 判断是否可达
            System.out.println("是否可达========"+ip.isReachable(2000));
             // 获取该InetAddress实例的IP字符串
            System.out.println(ip.getHostAddress());
            System.out.println(ip.getHostName());
            // 根据原始IP地址来获取对应的InetAddress实例
            InetAddress local=InetAddress.getByAddress(new byte[]{127,0,0,1});
            System.out.println("本机是否可达"+local.isReachable(5000));
            System.out.println("本机全限定域名"+local.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
