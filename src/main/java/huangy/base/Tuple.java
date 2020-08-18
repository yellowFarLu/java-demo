package huangy.base;

/**
 * 元组，用于1次返回多个对象
 * 可以根据不同类型的变量进行返回
 * @author huangy on 2019-04-06
 */
public class Tuple {

    public static <A, B> TwoTuple<A, B> TwoTuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

}
