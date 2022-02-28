package NetT;

import java.io.IOException;

/**
 * Package: NetT
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/30 22:21
 * <p>
 * Version: 0.0.1
 */
public class MultiThreadDown {
    public static void main(String[] args) throws IOException {
        final DownUtil downUtil = new DownUtil("https://img04.sogoucdn.com/app/a/100520093/61782be166c826c8-653ea5468e5789eb-4cace7d37694e31c752dc34f82697fdf.jpg",
                "ios.png", 4);
        downUtil.download();
        new Thread(()->{
           while (downUtil.getCompleteRate()<1){
               System.out.println("已完成"+downUtil.getCompleteRate());
               try {
                   Thread.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
    }
}
