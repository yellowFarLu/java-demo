package huangy.hythread.tool;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @author huangy on 2019-05-04
 */

/**
 * 食物
 */
class Food {
    public final static String[] food = {
            "打边炉","奶味芦笋汤","糟片鸭","烤花揽桂鱼","苦中作乐","七星丸","鸭黄豆腐","贝丝扒菜胆","脆炒南瓜丝","龙凤双腿",
            //省略部分代码....
    };

    private static Random random = new Random();
    public static String getRandomFood(){
        return food[random.nextInt(food.length)];
    }
}

/**
 * 厨师
 */
class ShanZhiRunnable implements Runnable {
    Exchanger<String> exchanger;
    Random random = new Random();
    public ShanZhiRunnable(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            try {

                String food = Food.getRandomFood();
                System.out.println("==>山治开始做 " + food);
                Thread.sleep(random.nextInt(500));
                System.out.println("==>山治把 " + food + " 给做好了,给路飞送过去");
                String exchange = exchanger.exchange(food);
                System.out.println("==>山治收到路飞的评语:" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class LuFeiRunnable implements Runnable{
    Exchanger<String> exchanger;
    Random random = new Random();
    public LuFeiRunnable(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String temp = "开吃啦...";

        while (true){
            try {
                System.out.println("--->路飞正在等待");
                String food = exchanger.exchange(temp);
                System.out.println("--->路飞拿到山治做的菜: " + food);
                Thread.sleep(random.nextInt(500));
                System.out.println("--->路飞吃完" + food);
                temp = food + "太好吃!太感谢山治了...";

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new LuFeiRunnable(exchanger)).start();
        new Thread(new ShanZhiRunnable(exchanger)).start();
    }

}
