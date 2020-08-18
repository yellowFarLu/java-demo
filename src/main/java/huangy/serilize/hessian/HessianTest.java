package huangy.serilize.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;


public class HessianTest {

    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setAge(1);
        person.setName("idea");
        person.setSex("man");
        person.setBigDecimal(new BigDecimal("101"));

        // Hessian序列化对象
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(person);
        byte[] userByte = os.toByteArray();

        // Hessian的反序列化对象
        ByteArrayInputStream is = new ByteArrayInputStream(userByte);
        HessianInput hi = new HessianInput(is);
        Person newPerson = (Person) hi.readObject();
        System.out.println(newPerson);
    }
}
