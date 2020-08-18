package huangy.hythread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author huangy on 2019-05-03
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "TaskWithResult, id=" + id;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // submit方法提交Callable任务，并且返回Future
            futures.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }

}
