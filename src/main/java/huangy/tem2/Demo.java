package huangy.tem2;

import java.util.concurrent.*;

/**
 * 生产者消费者模式
 * 消费者端使用Fork-Join实现并发计算，及数据的合并
 *
 * 任务的计算，我们假设计算  将1—1001数字相加 的结果
 *
 *
 * @author huangy on 2020-01-02
 */
public class Demo {

    // 假设有10个生产者
    private static ExecutorService producerPool = Executors.newFixedThreadPool(5);

    // 假设有10个消费者
    private static ExecutorService consumerPool = Executors.newFixedThreadPool(5);

    // ForkJoin执行框架
    private static ForkJoinPool forkJoinPool = new ForkJoinPool();

    // 阻塞队列，假设队列长度为5
    private static ArrayBlockingQueue<MyForkJoinTask> queue = new ArrayBlockingQueue<>(5);

    private static final Integer MAX = 200;

    // 中断标志位
    private static Boolean brokenTag = false;

    // 任务的偏移量，类似lastId
    private static volatile Integer index = 0;

    public static void main(String[] args) {

        // 生产者生成数据
        producerPool.execute(new ProducerTask());

        // 消费者消费数据
        consumerPool.execute(new ConsumerTask());
    }

    private static class ProducerTask implements Runnable {

        @Override
        public void run() {

            /*
             * 生产者端（A线程组）从DB拉取任务，放到阻塞队列中，
             * 假设任务总数为1000
             */

            // 从当前偏移开始获取任务，如果中断了，一定会保存这个偏移
            Integer currentIndex = getCurrentIndexFromDB();

            for (int i = currentIndex; i < 1000; i++) {

                try {

                    // 1、假设从DB拉取任务
                    // ...

                    // 2、A线程组将任务放到队列中
                    queue.put(new MyForkJoinTask(1, 1001));

                } catch (InterruptedException e) {

                    // 假如接收到"中断"信号，不再产生新的任务
                    System.out.println("接收到中断信号，不产生新的任务");

                    // 保存当前偏移
                    saveIndexToDB();

                    return;

                }

            }
        }
    }

    // 假设将index入库到DB
    private static void saveIndexToDB() {

    }


    private static Integer getCurrentIndexFromDB() {
        return index;
    }

    private static class ConsumerTask implements Runnable {

        @Override
        public void run() {

            // 中断了，并且队列中没有元素，则关闭消费者
            if (brokenTag) {
                return;
            }

            while (!queue.isEmpty()) {

                /*
                 * 消费者（B线程组）从队列中获取任务，
                 * 并且使用Fork-Join框架进行并行计算
                 */

                Integer result = null;
                MyForkJoinTask task = null;

                try {
                    // 1、从队列中获取任务
                    task = queue.take();

                    // 2、ForkJoin计算结果
                    ForkJoinTask<Integer> taskFuture =  forkJoinPool.submit(task);
                    try {
                        result = taskFuture.get();
                    } catch (Exception e) {
                        // 执行异常了， 把这个任务重新扔到队列中，再次执行
                        queue.put(task);
                    }
                    System.out.println("一个任务计算完成了， result=" + result);
                    System.out.println();

                    // 3、假如结果入库
                    // ...

                } catch (InterruptedException e) {

                    // 假如接收到"中断"信号，则尝试消费完当前任务
                    brokenTag = true;

                    // 计算完当前任务后，停止消费者

                }

            }
        }
    }

    static class MyForkJoinTask extends RecursiveTask<Integer> {

        // 子任务开始计算的值
        private Integer startValue;

        // 子任务结束计算的值
        private Integer endValue;

        public MyForkJoinTask(Integer startValue , Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
            // 可以正式进行累加计算了
            if(endValue - startValue < MAX) {
                System.out.println("开始计算的部分：startValue = " + startValue + ";endValue = " + endValue);
                Integer totalValue = 0;
                for(int index = this.startValue ; index <= this.endValue  ; index++) {
                    totalValue += index;
                }
                return totalValue;
            }
            // 否则再进行任务拆分，拆分成两个任务
            else {
                MyForkJoinTask subTask1 = new MyForkJoinTask(startValue, (startValue + endValue) / 2);
                subTask1.fork();
                MyForkJoinTask subTask2 = new MyForkJoinTask((startValue + endValue) / 2 + 1 , endValue);
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }
    }
}