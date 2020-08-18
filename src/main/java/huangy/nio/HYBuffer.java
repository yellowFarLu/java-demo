package huangy.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/**
 * @author huangy on 2019-04-25
 */
public class HYBuffer {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        IntBuffer intBuffer = buffer.asIntBuffer();

        intBuffer.put(1);
        intBuffer.put(2);

        intBuffer.put(1, 15);

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }

}
