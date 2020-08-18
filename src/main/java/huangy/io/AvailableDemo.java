package huangy.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author huangy on 2019-04-21
 */
public class AvailableDemo {

    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference/MyDate.java")));

        int remain;
        while ((remain = in.available()) != 0) {
            System.out.println("remian=" + remain);
            System.out.print((char) in.readByte());
        }
    }

}
