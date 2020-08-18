package huangy.head_first.factory_pattern;

import huangy.head_first.strategy_pattern.Durk;

/**
 * 生产鸭对象的工厂
 */
public class DurkFactory {

    public Durk getDuck() {
        return new Durk();
    }

}
