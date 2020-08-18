package huangy.serilize;

import huangy.serilize.hessian.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * jdk序列化
 */
public class TestObjSerializeAndDeserialize {

    private static final String FILE_PATH =
            "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/serilize/Person.txt";

    public static void main(String[] args) throws Exception {

        // 序列化Person对象
        SerializePerson();

        // 反序列Perons对象
        Person p = DeserializePerson();

        System.out.println(p);
    }

    /**
     * MethodName: SerializePerson
     * Description: 序列化Person对象
     */
    private static void SerializePerson() throws FileNotFoundException,
            IOException {
        Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("男");
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File(FILE_PATH)));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson
     * Description: 反序列Perons对象
     */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(FILE_PATH)));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }

}
