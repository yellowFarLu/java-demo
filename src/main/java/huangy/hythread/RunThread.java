package huangy.hythread;

public class RunThread extends Thread {

    /** volatile */
    private boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("子线程：进入 run() 方法中...");
        while (isRunning == true) {
            // doSomething()
        }
        System.out.println("子线程：线程结束了...");
    }

    public static void main(String[] args) throws InterruptedException {

        RunThread myThread = new RunThread();
        myThread.setRunning(false);
        System.out.println("主线程： isRunning 的值已经设置为了 false");
        Thread.sleep(1000);

        myThread.start();

        System.out.println("主线程开始睡觉");
        Thread.sleep(3000);

        System.out.println("主线程中查看=" + myThread.isRunning);
    }
}
