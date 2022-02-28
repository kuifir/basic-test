package exceptionTest.catchAndThrowTest;

/**
 * Package: exceptionTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/20 16:08
 * <p>
 * Version: 0.0.1
 */
public class AuctionException extends Throwable {
    public AuctionException(String s) {
        super(s);
    }

    public AuctionException() {
    }
}
