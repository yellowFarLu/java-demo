package huangy.hyreference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReferenceTest {

    private static String[] array;

    public ReferenceTest() {
    }

    //在这个类中定义了一个静态方法drainMemory()，此方法旨在消耗大量的内存，促使JVM运行垃圾回收。
    public static void drainMemory() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                final int MAX = 1024 * 100000;
                array = new String[MAX];
                for(int i = 0; i < MAX; i++) {
                    for(int j = 'a'; j <= 'z'; j++) {
                        array[i] += (char)j;
                    }
                }
            }
        });
    }
}
