package huangy.head_first.strategy_pattern;

/**
 *  飞行行为具体实现类
 * （算法族的其中一个算法）
 * @author huangy on 2019-05-18
 */
public class FlyBehaviorToSky implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("i can fly to sky");
    }
}
