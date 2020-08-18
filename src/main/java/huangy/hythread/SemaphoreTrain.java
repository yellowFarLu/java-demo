package huangy.hythread;

import java.util.concurrent.Semaphore;

public class SemaphoreTrain {

    static class Worker extends Thread {
        // 工人编号，表示哪个工人在使用
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Worker num " + num + " use machine");
                Thread.sleep(2000);
                System.out.println("Worker num " + num + " stop use");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int worker = 6;    //工人数
        int machine = 4;  //机器数，表示最多只能有4个线程同时执行
        Semaphore semaphore = new Semaphore(machine);
        for (int i = 0; i < worker; i++) {
            new Worker(i, semaphore).start();
        }
    }
}
