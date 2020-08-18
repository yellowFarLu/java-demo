package huangy.hythread.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 使用Fork-Join框架计算1+2+3+4的结果，每个任务最多执行2个数的相加
 * @author huangy on 2019-11-23
 */
public class CountTask extends RecursiveTask<Integer> {

    /**
     * 阈值，用于控制每个任务最多执行相加的数
     */
    private static final int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果足够小，就可以进行计算
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分成2个子任务进行计算
            int middle = (end - start) / 2 + start;

            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            // 调用fork()方法执行任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行，并且得到结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // 合并子任务的结果
            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
