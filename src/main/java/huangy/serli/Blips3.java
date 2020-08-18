package huangy.serli;

import java.io.*;

/**
 * @author huangy on 2019-05-02
 */
public class Blips3 implements Externalizable {

    private int i1;

    private int i2;

    private int i3;

    public Blips3() {
        System.out.println("Blips3 Constructor");
    }

    public Blips3(int i1, int i2, int i3) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
    }

    @Override
    public String toString() {
        return "Blips3{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                ", i3=" + i3 +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(i1);
        out.writeInt(i2);
        out.writeInt(i3);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 数据的读取顺序和写入顺序一致
        i1 = in.readInt();
        i2 = in.readInt();
        i3 = in.readInt();
    }

    public static void main(String[] args) throws Exception {
        Blips3 b3 = new Blips3(1, 2, 3);

        final String path = "Blips.out";

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(path)
        );
        out.writeObject(b3);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path)
        );
        b3 = (Blips3) in.readObject();
        System.out.println(b3);
    }
}
