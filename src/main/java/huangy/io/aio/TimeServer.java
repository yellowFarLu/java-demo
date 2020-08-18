package huangy.io.aio;

/**
 * @author huangy on 2020-05-03
 */
public class TimeServer {

    public static void main(String[] args) {
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(8080);
        new Thread(timeServer, "AsyncTimeServerHandler").start();
    }

}
