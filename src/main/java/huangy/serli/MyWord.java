package huangy.serli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-05-02
 */
class House implements Serializable {

}

class Animal implements Serializable {
    private String name;

    private House house;

    public Animal(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", house=" + house +
                '}';
    }
}

public class MyWord {

    public static void main(String[] args) throws Exception {
        House house = new House();

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("one", house));
        animals.add(new Animal("two", house));
        animals.add(new Animal("three", house));

        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(buf1);
        out.writeObject(animals);
        out.writeObject(animals);

        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(buf2);
        out2.writeObject(animals);


        ObjectInputStream in1 = new ObjectInputStream(
                new ByteArrayInputStream(buf1.toByteArray())
        );

        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(buf2.toByteArray())
        );

        List animals1 = (List)in1.readObject();
        List animals2 = (List)in1.readObject();

        // 系统无法知道in2内的对象是in1的对象的别名（无法知道2个对象是一样的），因此in2会产生出完全不同的对象网
        List animals3 = (List)in2.readObject();

        System.out.println(animals1);
        System.out.println(animals2);
        System.out.println(animals3);
    }

}