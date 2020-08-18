package huangy.hythread.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author chenxihua
 * @Date 2018年9月17日
 */
public class PipeTest {

    public static void main(String[] args) throws Exception {

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        // 通过connect方法将 输入、输出流 绑定起来，否则会报错
        pis.connect(pos);

        new MyProducer(pos).start();

        new MyConsumer(pis).start();


    }
}
