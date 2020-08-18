package huangy.serli;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author huangy on 2019-05-02
 */
public class FreezeAlien {

    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream(
                        "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/serli/test.txt")
        );
        Alien alien = new Alien();
        out.writeObject(alien);
    }

}
