package huangy.serli;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author huangy on 2019-05-02
 */
public class RecoverCADState {

    public static void main(String[] args) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(
                        "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/serli/test.txt")
        );

        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>)inputStream.readObject();
        Line.deserializeStaticState(inputStream);

        List<Shape> shapes = (List<Shape>)inputStream.readObject();

        System.out.println(shapeTypes);
        System.out.println("-----------------");

        System.out.println(shapes);
    }

}
