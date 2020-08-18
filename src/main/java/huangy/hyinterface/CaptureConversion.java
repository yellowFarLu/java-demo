package huangy.hyinterface;

/**
 * 类型捕获
 * @author huangy on 2019-04-07
 */
public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        /*
         * f1需要一个确切的类型才能调用，f2的无界通配符可以捕获类型参数，因此能够完成f1的调用
         */
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);

        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
}
