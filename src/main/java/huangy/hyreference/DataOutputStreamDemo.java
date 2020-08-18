package huangy.hyreference;

import java.io.*;

/**
 * @author huangy on 2019-04-21
 */
public class DataOutputStreamDemo {

    public static void main(String[] args) throws Exception {
        String file = "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference/test.txt";

        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)));

        out.writeUTF("哈哈");
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );
        String result = in.readUTF();
        System.out.println(result);
    }

}
