package exceptionTest.catchAndThrowTest;

/**
 * Package: exceptionTest
 * <p>
 * Description： catch和throw同时使用
 * 一个异常出现时，单靠某个方法无法完全处理该异常，必须几个方法协作才可以完全处理该异常
 * 也就是说，在异常处理的过程中，程序只对异常进行部分处理，还有些处理需要在调用者中才能完成
 * 所以再次抛出该异常，让方法的调用者也能捕获到该异常
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 15:44
 * <p>
 * Version: 0.0.1
 */
public class AuctionTest {
    private double initPrice = 30.0;

    // 因为该方法中显示抛出了AuctionException异常
    // 所以此处需要声明抛出AuctionException异常
    public void bid(String bidPrice) throws AuctionException {
        double d = 0.0;
        try {
            d = Double.parseDouble(bidPrice);
        } catch (Exception e) {
            // 此处完成本方法中可以对异常执行的修复处理
            // 此处仅仅是在控制台打印异常的跟踪栈信息
            e.printStackTrace();
            // 再次抛出自定义异常
            throw new AuctionException("竞拍价必须是数值，不能包含其他首字符！");
        }
        if (initPrice > d) {
            throw new AuctionException("竞拍价比起拍价低，不允许竞拍！");
        }
        initPrice = d;
    }

    public static void main(String[] args) {
        AuctionTest at =new AuctionTest();
        try {
            at.bid("df");
        }catch (AuctionException ae){
            // 再次捕获bid（）方法中的异常，并对该异常进行处理
            System.out.println(ae.getMessage());
        }
    }
}
