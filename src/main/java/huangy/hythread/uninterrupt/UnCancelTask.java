package huangy.hythread.uninterrupt;

import javafx.concurrent.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 不可取消的任务在退出前恢复中断
 * 这个例子表现了不可取消的任务，怎么在退出先恢复中断，即保存中断状态，给上层调用看到
 * @author huangy on 2019-02-02
 */
public class UnCancelTask {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Task task = getNextTask(new ArrayBlockingQueue<>(1));

                System.out.println(task);
            }

            private Task getNextTask(BlockingQueue<Task> queue) {

                boolean interrupted = false;

                try {
                    while (true) {
                        try {
                            System.out.println("get task");
                            // 阻塞操作，内部会先判断中断标记位，如果该标记位是true，抛出异常
                            return queue.take();

                        } catch (Exception e) {

                            /*
                             * 方法1：直接在catch里面重置标记，但会引起死循环
                             * 死循环指的是 一直抛出InterruptedException异常，没有执行真正获取task的操作
                             */
//                            Thread.currentThread().interrupt();

                            /*
                             * 方法2：做一个标记，在循环外面重设标记位
                             */
                            interrupted = true;
                            e.printStackTrace();
                        }
                    }

                } finally {
                    if (interrupted) {
                        /*
                         * 拿完结果之后，自然会退出循环，来到finaly，在这里恢复中断的标志位。
                         * 这其实是一个延迟处理中断的例子
                         */
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        t.start();

        t.interrupt();
    }

}


