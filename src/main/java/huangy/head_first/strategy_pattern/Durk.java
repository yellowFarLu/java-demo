package huangy.head_first.strategy_pattern;

/**
 * 鸭子类（客户端）
 * @author huangy on 2019-05-18
 */
public class Durk {

    protected FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }
}
