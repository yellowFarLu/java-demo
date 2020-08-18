package huangy.hythread.hyblockingqueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * 下面列子，使用同步队列模拟吐司面包的加工过程
 * 制作吐司 ——》 给吐司摸黄油 ——》 涂果酱
 * @author huangy on 2019-05-04
 */

/**
 * 吐司实例
 */
class Toast {
    public enum Status {
        DAY, BUTTERED, JAMMED
    }

    private Status status = Status.DAY;

    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}

/**
 * 同步队列的封装
 */
class ToastQueue extends LinkedBlockingQueue<Toast> {}

/**
 * 制作吐司的步骤
 */
class Toaster implements Runnable {
    private ToastQueue dryQueue;

    private int count = 0;

    private Random random = new Random(47);

    public Toaster(ToastQueue dryQueue) {
        this.dryQueue = dryQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));

                Toast toast = new Toast(count++);

                // 把创建好的吐司放到dryQueue
                dryQueue.put(toast);

                System.out.println("dryQueue put toast, toast=" + toast);
            }

        } catch (InterruptedException e) {
            System.out.println("Toaster InterruptedException, e=" + e);
        }

        System.out.println("Toaster off");
    }
}

/**
 * 摸黄油的步骤
 */
class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                System.out.println("Butterer wait dryQueue");

                Toast toast = dryQueue.take();

                System.out.println("Butterer take from dryQueue, toast=" + toast);

                // 加工
                toast.butter();

                butteredQueue.put(toast);
                System.out.println("butteredQueue put toast, toast=" + toast);
            }

        } catch (InterruptedException e) {
            System.out.println("Butterer InterruptedException, e=" + e);
        }

        System.out.println("Butterer off");
    }
}

class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                System.out.println("Jammer wait butteredQueue");

                Toast toast = butteredQueue.take();

                System.out.println("Jammer take from butteredQueue, toast=" + toast);

                toast.jam();

                finishedQueue.put(toast);

                System.out.println("finishedQueue put toast, toast=" + toast);
            }

        } catch (InterruptedException e) {
            System.out.println("Jammer InterruptedException, e=" + e);
        }

        System.out.println("Jammer off");
    }
}

class Eater implements Runnable {

    private ToastQueue finishedQueue;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                System.out.println("Eater wait finishedQueue");

                Toast toast = finishedQueue.take();

                System.out.println("Eater take toast from finishedQueue, toast=" + toast);
            }

        } catch (InterruptedException e) {
            System.out.println("Eater InterruptedException, e=" + e);
        }

        System.out.println("Eater off");
    }
}


public class ToastOMatic {

    public static void main(String[] args) {
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butteredQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();

        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new Toaster(dryQueue));

        exec.execute(new Butterer(dryQueue, butteredQueue));

        exec.execute(new Jammer(butteredQueue, finishedQueue));

        exec.execute(new Eater(finishedQueue));

        exec.shutdown();
    }

}























