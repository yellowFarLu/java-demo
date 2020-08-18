package huangy.hythread.cas;

import huangy.hyinterface.Person;
import huangy.hythread.SleepUtils;

import java.util.concurrent.atomic.*;

/**
 * @author huangy on 2019-11-23
 */
public class AtomicDemo {

    private static void atomicIntegerDemo() {
        AtomicInteger integer = new AtomicInteger(1);

        boolean result = integer.compareAndSet(1, 2);

        integer.lazySet(3);

        System.out.println("更新结果, result=" + result);
        System.out.println("新的值为，value=" + integer.get());
    }

    private static void atomicArrayDemo() {
        int[] arr = {1, 2, 3, 4, 5};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        atomicIntegerArray.addAndGet(1, 100);
        System.out.println(atomicIntegerArray.get(1));
    }

    private static void atomicReferenceFieldUpdaterDemo() {
        Person person = new Person(1001,"whisper");

        AtomicReferenceFieldUpdater<Person,String> updater =
                AtomicReferenceFieldUpdater.newUpdater(Person.class, String.class,"tem2");

        boolean isSuccess = updater.compareAndSet(person,"whisper","godyan");

        System.out.println("更新的结果=" + isSuccess);
        System.out.println("修改后的name为:"+person.getTem2());
    }

    private static final Integer INIT_NUM = 10;

    private static final Integer TEM_NUM = 20;

    private static final Integer UPDATE_NUM = 100;

    private static final Boolean INITIAL_MARK = Boolean.FALSE;

    private static AtomicMarkableReference<Integer> atomicMarkableReference =
            new AtomicMarkableReference<>(INIT_NUM, INITIAL_MARK);

    /**
     * 由于线程B修改了对象，标记由false改为true，所以当上下文切换为线程A的时候，如果标记不一致CAS方法就会返回false
     * 可以用于解决ABA问题
     */
    private static void atomicMarkableReferenceDemo() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " ： 初始值为：" + INIT_NUM +
                    " , 标记为： " + INITIAL_MARK);

            SleepUtils.second(1);

            if (atomicMarkableReference.compareAndSet(INIT_NUM, UPDATE_NUM,
                    atomicMarkableReference.isMarked(), Boolean.TRUE)) {
                System.out.println(Thread.currentThread().getName() + " ： 修改后的值为：" +
                        atomicMarkableReference.getReference() + " , 标记为： " +
                        atomicMarkableReference.isMarked());
            }else{
                System.out.println(Thread.currentThread().getName() +  " CAS返回false");
            }
        }, "线程A").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " ： 初始值为：" +
                    atomicMarkableReference.getReference() + " , 标记为： " + INITIAL_MARK);
            atomicMarkableReference.compareAndSet(atomicMarkableReference.getReference(),
                    TEM_NUM, atomicMarkableReference.isMarked(), Boolean.TRUE);
            System.out.println(Thread.currentThread().getName() + " ： 修改后的值为：" +
                    atomicMarkableReference.getReference() + " , 标记为： " + atomicMarkableReference.isMarked());
        }, "线程B").start();

    }

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater
            .newUpdater(User.class, "old");

    public static void atomicIntegerFieldUpdaterDemo() {
        User conan = new User("conan", 10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    public static void main(String[] args) {
        atomicIntegerFieldUpdaterDemo();
    }

    public static class User {
        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
