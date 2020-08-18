package huangy.hyinterface;

/**
 * @author huangy on 2019-04-06
 */
public class UnboundedWild3 {

    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);
        holder.set(new UnboundedWild3());

//        T t = holder.get();
    }

    static void unboundedArf(Holder<?> holder, Object arg) {
        /*
         * 这一点可以看出 Holder holder和Holder<?> holder的区别
         *  Holder holder； holder.set(arg); 只是警告，原生类型传递给泛型类型
         *  Holder<?> holder； holder.set(arg);  会编译异常
         */
//        holder.set(arg);
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubType(Holder<? extends T> holder, T arg) {
//        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.set(arg);
//        T t = holder.get();
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw;

        raw = new Holder();

        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();

        Long lng = 1L;
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArf(raw, lng);
        unboundedArf(qualified, lng);
        unboundedArf(unbounded, lng);
        unboundedArf(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        // 下面这句，由于元素返回类型是？，编译器不知道是什么类型，因此只能用Object来接收了
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        /*
         * raw使得返回值是Object类型
         */
//        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
        /*
         * lng类型不匹配
         */
//        Long r7 = exact2(unbounded, lng);
        /*
         * lng类型不匹配
         */
//        Long r8 = exact2(bounded, lng);


        /*
         * Holder<? extends T> holder被转换成了 Holder holder
         */
//        Long r9 = wildSubType(raw, lng);
        Long r10 = wildSubType(qualified, lng);
//        Object r11 = wildSubType(unbounded, lng);
        Long r12 = wildSubType(bounded, lng);

        wildSuperType(raw, lng);
        wildSuperType(qualified, lng);
//        wildSuperType(unbounded, lng);
//        wildSuperType(bounded, lng);
    }
}


















