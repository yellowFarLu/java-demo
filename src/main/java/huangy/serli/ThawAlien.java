package huangy.serli;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author huangy on 2019-05-02
 */
public class ThawAlien {

    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(
                        "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/serli/test.txt"
                )
        );

        Object object = in.readObject();
        System.out.println(object.getClass());
    }
}
