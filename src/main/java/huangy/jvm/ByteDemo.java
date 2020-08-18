package huangy.jvm;

/**
 * @author huangy on 2019-10-26
 */
public class ByteDemo {

    public static void main(String[] args) {

        {
            byte[] arr = new byte[64 * 1024 * 1024];
        }

        System.gc();
    }

}
