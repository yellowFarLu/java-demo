package huangy.hythread.queue;

import java.util.concurrent.*;

/**
 * @author huangy on 2019-05-04
 */

class DelayedTask implements Delayed {

    /**
     * 唯一标明这个任务
     */
    private int id;

    /**
     * 延迟多久就可以执行这个任务（相对时间）
     */
    private long deplay;

    /**
     * 到期时间（绝对时间）
     */
    private long deadLine;

    public DelayedTask(int id, long deplay) {
        this.id = id;
        this.deplay = deplay;

        // 计算过期时间（到这个点就过期了）
        this.deadLine = System.currentTimeMillis() + deplay;
    }

    /**
     * 返回任务剩余的延迟时间
     * @param unit 单位，剩余时间必须转换成传入的单位形式
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(deadLine - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 延迟队列是有序的
     * 出队的顺序就是延迟队列中元素的顺序
     *
     * 本例子中，越早过期的任务在前面
     */
    @Override
    public int compareTo(Delayed other) {
        DelayedTask otherDelayedTask = (DelayedTask)other;
        if (this.deadLine < otherDelayedTask.deadLine) {
            return -1;
        } else if(this.deadLine > otherDelayedTask.deadLine) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "DelayedTask{" +
                "id=" + id +
                ", deplay=" + deplay +
                ", deadLine=" + deadLine +
                '}';
    }
}

/**
 * 延迟队列消费者
 */
class DelayedTaskComsumer implements Runnable {

    private DelayQueue<DelayedTask> queue;

    public DelayedTaskComsumer(DelayQueue<DelayedTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            while (!queue.isEmpty()) {

                /*
                 * 按照队列中元素的顺序"取"
                 * 如果队列头部的元素没有到时间，则会阻塞当前线程
                 */
                DelayedTask delayedTask = queue.take();

                System.out.println("DelayedTaskComsumer get delayedTask, delayedTask=" + delayedTask);

                TimeUnit.MILLISECONDS.sleep(100);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DelayedTaskComsumer finished");
    }
}



public class DelayedQueueDemo {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(i, i * 100));
        }

        exec.execute(new DelayedTaskComsumer(queue));

        exec.shutdown();
    }

}
