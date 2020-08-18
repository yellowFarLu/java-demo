package huangy.hythread;

/**
 * @author huangy on 2019-05-03
 */

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was Interrupted. "
            + " isInterrupted=" + isInterrupted());
        }
        System.out.println(getName() + " Sleeper awake");
    }
}

class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println(getName() + " InterruptedException");
        }
        System.out.println(getName() + " Joiner awake");
    }
}

public class JoinDemo {

    public static void main(String[] args) {
        Sleeper sleeperOne = new Sleeper("sleeperOne", 1500);

        Sleeper sleeperTwo = new Sleeper("sleeperTwo", 1500);

        Joiner joinerOne = new Joiner("joinerOne", sleeperOne);

        Joiner joinerTwo = new Joiner("joinerTwo", sleeperTwo);

        sleeperOne.interrupt();
    }

}
