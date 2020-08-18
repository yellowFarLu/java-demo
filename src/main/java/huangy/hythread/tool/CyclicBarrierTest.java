package huangy.hythread.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangy on 2019-05-04
 */
public class CyclicBarrierTest {

    class MainTask implements Runnable {

        @Override
        public void run() {
            System.out.println(">>>>所有线程到达CyclicBarrier，action开始执行!<<<<");
        }

    }

    class SubTask implements Runnable {
        private String name;
        private CyclicBarrier cyclicBarrier;

        SubTask(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {
                // 当线程到达栅栏时，将调用await方法，这个将阻塞当前线程直到所有线程都到达栅栏位置
                System.out.println("SubTask 到达, name=" + this.name);
                cyclicBarrier.await();
                System.out.println("SubTask 继续执行, name=" + this.name);
            } catch (InterruptedException  e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, test.new MainTask());

        SubTask A = test.new SubTask("A", cyclicBarrier);
        SubTask B = test.new SubTask("B", cyclicBarrier);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(A);
        executor.execute(B);

    }
}
