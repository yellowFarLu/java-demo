package huangy.serilize.hessian;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>ClassName: Person<p>
 * <p>Description:测试对象序列化和反序列化<p>
 */
public class Person extends SuperClass {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;
    private BigDecimal bigDecimal;

    public Person() {
        super.name = "superName";
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", bigDecimal=" + bigDecimal +
                '}' +  super.toString();
    }
}