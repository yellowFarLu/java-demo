package huangy.head_first.factory_pattern;

/**
 * 比萨 制作店
 * （1）涉及到工厂模式、模板方法模式
 * @author huangy on 2019-05-19
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;

        // 创建pizza的代码和其他固定代码分离开来
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // 该方法负责创建对象，如同一个工厂（抽象工厂，具体实现由子类负责）
    public abstract Pizza createPizza(String type);
}
