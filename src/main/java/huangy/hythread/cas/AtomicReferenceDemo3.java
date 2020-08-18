package huangy.hythread.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 演示2个变量的自增操作 如何保持原子性
 */
public class AtomicReferenceDemo3 {

    private AtomicReference<Reference> atomicReference;

    /**
     * 构建器中初始化AtomicReference
     */
    public AtomicReferenceDemo3() {
        Reference reference = new Reference(0, 0);
        this.atomicReference = new AtomicReference<>(reference);
    }

    /**
     * 原子性保持自增
     */
    public void atomicIncr() {
        Reference referenceOld;
        Reference referenceNew;

        long sequence;
        long sequence2;

        while (true) {
            referenceOld = this.atomicReference.get();

            sequence = referenceOld.getSequence();
            sequence++;

            sequence2 = referenceOld.getSequence2();
            sequence2++;

            referenceNew = new Reference(sequence, sequence2);

            /*
             * 比较交换
             */
            if (this.atomicReference.compareAndSet(referenceOld, referenceNew)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        AtomicReferenceDemo3 demo3 = new AtomicReferenceDemo3();

        // 模拟多个线程同时更新
        Thread t1 = new Thread(() -> {
           func(demo3);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            func(demo3);
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            func(demo3);
        });
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(demo3.getAtomicReference().get());
    }

    private static void func(AtomicReferenceDemo3 demo3) {

        for (int i = 0; i < 100000; i++) {
            demo3.atomicIncr();
        }
    }

    public AtomicReference<Reference> getAtomicReference() {
        return atomicReference;
    }
}

/**
 * 业务场景模拟
 */
class Reference {

    public Reference(long sequence, long sequence2) {
        this.sequence = sequence;
        this.sequence2 = sequence2;
    }

    /**
     * 序列
     */
    private long sequence;

    /**
     * 序列2
     */
    private long sequence2;

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public long getSequence2() {
        return sequence2;
    }

    public void setSequence2(long sequence2) {
        this.sequence2 = sequence2;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "sequence=" + sequence +
                ", sequence2=" + sequence2 +
                '}';
    }
}