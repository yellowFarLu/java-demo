package huangy.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * @author huangy on 2019-10-13
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws Exception {

        // 利用引用队列来接收消息
        final ReferenceQueue<Node> referenceQueue = new ReferenceQueue<>();

        Thread thread = new Thread() {
            public void run() {
                while (true) {

                    Object obj = referenceQueue.poll();

                    if (obj != null) {
                        System.out.println("我收到一条消息了");
                        try {
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(obj);
                            System.out.println("gc will collect："
                                    + result.getClass() + "@"
                                    + result.hashCode() + "\t"
                                    + result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                }
            }
        };
        thread.start();

        // 稍微睡一下，等子线程完全启动
        Thread.sleep(100);

        // 虚引用
        PhantomReference<Node> phantomReference
                = new PhantomReference<>(new Node(), referenceQueue);

        System.gc();

        thread.join();
    }
}
