package huangy.java8;

import java.io.Serializable;

/**
 * @author huangy on 2019-06-06
 */
public class OuterTenantInfo implements Serializable {

    private Integer outerUid;

    private String name;

    public Integer getOuterUid() {
        return outerUid;
    }

    public void setOuterUid(Integer outerUid) {
        this.outerUid = outerUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OuterTenantInfo{" +
                "outerUid=" + outerUid +
                ", name='" + name + '\'' +
                '}';
    }
}
