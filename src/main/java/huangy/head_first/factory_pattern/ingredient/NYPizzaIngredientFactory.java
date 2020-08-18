package huangy.head_first.factory_pattern.ingredient;

/**
 * 抽象工厂子类（具体工厂），由该子类负责生成哪一种产品
 * @author huangy on 2019-05-19
 */
public class NYPizzaIngredientFactory extends PizzaIngredientFactory {

    @Override
    Dough createDoughSub() {
        return new HotDough();
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }
}
