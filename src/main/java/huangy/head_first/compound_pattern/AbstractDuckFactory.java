package huangy.head_first.compound_pattern;

/**
 * 使用工厂模式，确保鸭子是被包装过的
 * （1）此工厂应该生成不同类型鸭子的产品家族，所以使用抽象工厂模式
 * @author huangy on 2019-06-09
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck(Observable observable);

    public abstract Quackable createRedHeadDuck(Observable observable);

    public abstract Quackable createDuckCall(Observable observable);

    public abstract Quackable createRubberDuck(Observable observable);
}

