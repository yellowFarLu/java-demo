package huangy.io.aio;

/**
 * @author huangy on 2020-05-04
 */
public class TimeClient {

    public static void main(String[] args) {

        // 在实际项目中，不需要独立的线程创建异步连接对象，因为底层都是通过JDK系统回调实现的
        new Thread(new AsyncTimeClientHandler("127.0.0.1", 8080),
                "AsyncTimeClientHandler").start();
    }

}
