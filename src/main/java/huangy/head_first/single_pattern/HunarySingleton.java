package huangy.head_first.single_pattern;

/**
 * 饿汉模式
 * @author huangy on 2019-05-25
 */
public class HunarySingleton {

    /**
     * 在静态初始化器中创建单件。这段代码保证了线程安全
     * 加载类的时候就初始化了属性。等到线程访问该属性的时候，属性已经初始化好了。从而保证线程安全
     */
    private static HunarySingleton hunarySingleton = new HunarySingleton();

    private HunarySingleton() {
    }

    public static HunarySingleton getInstance() {
        return hunarySingleton;
    }
}
