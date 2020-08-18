package huangy.hyinterface;

/**
 * @author huangy on 2019-04-06
 */
public class Person {

    private String string;

    private Integer tem;

    public volatile String tem2;

    public Person(Integer tem, String tem2) {
        this.tem = tem;
        this.tem2 = tem2;
    }

    public Integer getTem() {
        return tem;
    }

    public void setTem(Integer tem) {
        this.tem = tem;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public Person(String string) {
        this.string = string;
    }

    public Person(String string, Integer tem) {
        this.string = string;
        this.tem = tem;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Person{" +
                "string='" + string + '\'' +
                "hashCode=" + hashCode() +
                '}';
    }
}
