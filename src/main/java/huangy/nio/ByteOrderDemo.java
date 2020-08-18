package huangy.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author huangy on 2019-04-25
 */
public class ByteOrderDemo {

    public static void main(String[] args) {
        // ByteBuffer里面2个字节，存1个字符
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);

        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }

}
