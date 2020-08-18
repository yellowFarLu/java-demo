package huangy.head_first.strategy_pattern;

/**
 * @author huangy on 2019-05-18
 */
public class Demo {

    public static void main(String[] args) {
        // 鸭子（客户端）
        Durk durk = new GreenDurk();

        // 鸭子把具体飞行的行为，委托给FlyBehavior具体对象实现（客户端使用 "火箭器 飞行的算法"）
        FlyBehavior flyBehaviorWithRocket = new FlyBehaviorWithRockt();
        durk.setFlyBehavior(flyBehaviorWithRocket);

        // 鸭子执行具体行为
        durk.performFly();
    }

}
