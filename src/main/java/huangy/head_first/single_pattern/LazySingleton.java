package huangy.head_first.single_pattern;

/**
 * @author huangy on 2019-05-25
 */
public class LazySingleton {

    private static LazySingleton single;

    private LazySingleton() {
    }

    public synchronized LazySingleton getInstance() {
        if (single == null) {
            single = new LazySingleton();
        }

        return single;
    }
}
