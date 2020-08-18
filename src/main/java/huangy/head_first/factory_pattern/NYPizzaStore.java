package huangy.head_first.factory_pattern;

import huangy.head_first.factory_pattern.pizza.NYStyleCheesePizza;

/**
 * 工厂子类
 * @author huangy on 2019-05-19
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {

        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }

        return null;
    }
}
