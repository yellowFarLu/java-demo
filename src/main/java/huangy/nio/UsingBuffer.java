package huangy.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author huangy on 2019-05-01
 */
public class UsingBuffer {

    public static void symm(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();

            char c1 = buffer.get();

            char c2 = buffer.get();

            buffer.reset();

            buffer.put(c2);

            buffer.put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();

        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);

        CharBuffer cb = bb.asCharBuffer();

        cb.put(data);

        System.out.println(cb.rewind());

        symm(cb);

        System.out.println(cb.rewind());

        symm(cb);

        System.out.println(cb.rewind());
    }

}