package huangy.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author huangy on 2019-05-01
 */
public class MappedByteBufferDemo {

    // 128MB的大小
    static int length = 0x8FFFFFF;

    public static void main(String[] args) throws Exception {
        /**
         * 该程序创建的文件为128MB，这可能比操作系统一次允许载入的内存的空间大，
         * 但我们可以一次访问到整个文件，因为一次只有一部分文件放入了内存，
         * 文件的其他部分被交换出去，需要访问的时候再交换进来。
         * 用这种方式，很大的文件（最大2G）也可以很容易修改。
         * 这样子可以极大提高性能。
         */
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile(
                "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/nio/text.txt",
                "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        mappedByteBuffer.slice();
        for (int i = 0; i < length; i++) {
            mappedByteBuffer.put((byte)'x');
        }

        System.out.println("finished write");

        for (int i = length / 2; i < length/2 + 6; i++) {
            System.out.print((char)mappedByteBuffer.get(i));
        }
    }

}
