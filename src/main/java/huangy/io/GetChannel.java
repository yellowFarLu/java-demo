package huangy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author huangy on 2019-04-21
 */
public class GetChannel {

    private static final String PATH =
            "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference/test.txt";

    public static void main(String[] args) throws Exception {

        // getChannel()方法可以获取通道，相当于在IO中使用NIO
        FileChannel fc = new FileOutputStream(PATH).getChannel();

        // ByteBuffer wrap(byte[] array)方法，将已经存在的字节数组包装成ByteBuffer
        fc.write(ByteBuffer.wrap("Some text".getBytes()));

        fc.close();

        // 获取随机访问文件的通道
        fc = new RandomAccessFile(PATH, "rw").getChannel();

        // 移动到末尾
        fc.position(fc.size());

        fc.write(ByteBuffer.wrap("Some more".getBytes()));

        fc.close();

        fc = new FileInputStream(PATH).getChannel();

        // 使用ByteBuffer allocate()方法生成ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        fc.read(buffer);

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
    }

}
