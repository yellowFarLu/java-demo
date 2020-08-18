package huangy.serilize.hessian;

import java.io.Serializable;

/**
 * @author huangy on 2020-01-03
 */
public class SuperClass implements Serializable {

    protected String name;

    @Override
    public String toString() {
        return "SuperClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
