package huangy.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *  CAS实现乐观锁
 *  AtomicInteger 实际上就是实现了一个乐观锁
 * @author huangy on 2020-04-12
 */
public class CasLock {

    // 通过反射方法获取unsafe对象
    private static final Unsafe unsafe = getUnsafe();

    private static final long valueOffset;

    private volatile int value;

    static {
        try {
            // 获取内存中value字段的偏移值
            valueOffset = unsafe.objectFieldOffset
                    (CasLock.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    public final boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    /**
     * 使用乐观锁更新value字段的值
     */
    public void incrValue() {

        int old;

        do {
            // 读取旧值（即预期的值）
            old = value;
        } while (!compareAndSet(old, old + 1));
    }

    public int getValue() {
        return value;
    }

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);

        } catch (Exception e) {
        }
        return null;
    }
}
