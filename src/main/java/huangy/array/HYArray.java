package huangy.array;

/**
 * @author huangy on 2019-04-07
 */

/*
 * 为传入的数组封装一下，保证其可以使用泛型
 */
class ClassParamter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParamter {
    public static  <T> T[] f(T[] arg) {
        return arg;
    }
}

public class HYArray {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};

        Integer[] ints2 = new ClassParamter<Integer>().f(ints);

        Double[] doubles2 = new ClassParamter<Double>().f(doubles);

        ints2 = MethodParamter.f(ints);

        doubles2 = MethodParamter.f(doubles);
    }

}
