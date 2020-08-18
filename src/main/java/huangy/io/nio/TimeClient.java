package huangy.io.nio;

/**
 * @author huangy on 2020-05-03
 */
public class TimeClient {

    public static void main(String[] args) {
        new Thread(new TimeClientHandle("127.0.0.1", 10301), "TimeClient").start();
    }

}
