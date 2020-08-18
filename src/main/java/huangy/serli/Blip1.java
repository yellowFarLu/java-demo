package huangy.serli;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author huangy on 2019-05-02
 */
public class Blip1 implements Externalizable {

    private Integer one = 3;

    public Integer getOne() {
        System.out.println("Blip1 getOne, one=" + one);
        return one;
    }

    public void setOne(Integer one) {
        System.out.println("Blip1 setOne, one=" + one);
        this.one = one;
    }

    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1 readExternal");
    }
}

class Blip2 implements Externalizable {

    private Integer one;

    public Integer getOne() {
        System.out.println("Blip2 getOne, one=" + one);
        return one;
    }

    public void setOne(Integer one) {
        System.out.println("Blip2 setOne, one=" + one);
        this.one = one;
    }


    public Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2 readExternal");
    }
}


