package huangy.head_first.single_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class DoubleCheckSingleton {

    // 利用volatile保证内存可见性，线程可以立刻看到singleton值的变更
    private volatile static DoubleCheckSingleton singleton;

    public DoubleCheckSingleton getInstance() {

        if (singleton == null) {

            /**
             * 优点就是：只有第一次多线程同时访问的时候，才会执行同步块代码，
             * 后面的多线程访问，直接在singleton == null判断false，然后就返回了singleton了
             */
            synchronized (DoubleCheckSingleton.class) {

                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }

            }
        }

        return singleton;
    }
}
