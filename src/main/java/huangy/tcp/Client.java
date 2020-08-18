package huangy.tcp;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
    private static int PORT = 9999;
    private static String HOST = "192.168.1.4";

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();

        /*
         * 测试#1: 默认设置
         * close之后，客户端会发送完全部数据，然后等待2MSL
         */
//        socket.setSoLinger(false, 0);

        /*
         * 测试#2
         * close之后，立即关闭连接，如果缓冲区里面有数据也会抛弃
         */
//         socket.setSoLinger(true, 0);

        /*
         * 测试#3 close 函数不会立刻返回，
         * 如果在 1s 内数据传输结束，则皆大欢喜，
         * 如果在 1s 内数据没有传输完，就直接丢弃掉，同时 RST 连接
         */
        socket.setSoLinger(true, 1);

        SocketAddress address = new InetSocketAddress(HOST, PORT);
        socket.connect(address);

        OutputStream output = socket.getOutputStream();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("hel");
        }
        byte[] request = sb.toString().getBytes("utf-8");
        output.write(request);
        long start = System.currentTimeMillis();
        socket.close();
        long end = System.currentTimeMillis();
        System.out.println("close time cost: " + (end - start));
    }
}
