package huangy.io.nio;

/**
 * NIO实现时间服务器
 * @author huangy on 2020-05-03
 */
public class TimeServer {

    public static void main(String[] args) {

        MultiplexerTimeServer server = new MultiplexerTimeServer(10301);

        new Thread(server, "MultiplexerTimeServer-001").start();
    }

}
