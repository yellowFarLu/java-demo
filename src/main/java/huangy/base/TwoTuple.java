package huangy.base;

/**
 * @author huangy on 2019-04-06
 */
public class TwoTuple<A, B> {

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    private A a;

    private B b;

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }
}
