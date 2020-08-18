package huangy.serli;

import java.io.*;

/**
 * @author huangy on 2019-05-02
 */
public class Blips {

    public static void main(String[] args) throws Exception {
        final String path = "Blips.out";

        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();

        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(path)
        );

        o.writeObject(b1);
//        o.writeObject(b2);
        o.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path)
        );
        // 反序列的类，一定要收public的构造函数
        b1 = (Blip1)in.readObject();
//        b2 = (Blip2)in.readObject();
        System.out.println(b1);
    }

}
