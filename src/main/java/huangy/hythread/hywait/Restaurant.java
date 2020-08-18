package huangy.hythread.hywait;

/**
 * 生产者和消费者
 * wait、notify()、notifyAll(）方式实现
 * @author huangy on 2019-05-03
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 肉
 */
class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}

/**
 * 服务员
 */
class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {

            // 检测是否中断，没有就继续循环
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        System.out.println("not meal, WaitPerson wait()");
                        // 等待厨师生产肉
                        wait();
                    }

                    System.out.println("WaitPerson got" + restaurant.meal);

                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        // 通知厨师准备下一份肉
                        restaurant.chef.notify();
                    }
                }

                TimeUnit.MILLISECONDS.sleep(1000);
            }

        } catch (InterruptedException e) {
            System.out.println("WaitPerson e=" + e);
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;

    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {

            // 检测是否中断，没有就继续循环
            while (!Thread.interrupted()) {

                synchronized (this) {
                    while (restaurant.meal != null) {
                        System.out.println("has meal, Chef wait()");
                        wait();
                    }
                }

                System.out.println("Chef Order up!");

                synchronized (restaurant.waitPerson) {
                    // 生产一份肉
                    restaurant.meal = new Meal(++count);

                    // 通知消费者
                    restaurant.waitPerson.notify();
                }

            }

        } catch (InterruptedException e) {
            System.out.println("Chef e=" + e);
        }
    }
}

public class Restaurant {
    Meal meal;

    WaitPerson waitPerson = new WaitPerson(this);

    Chef chef = new Chef(this);

    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
