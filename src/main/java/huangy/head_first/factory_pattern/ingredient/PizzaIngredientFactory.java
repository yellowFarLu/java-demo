package huangy.head_first.factory_pattern.ingredient;

/**
 * 比萨原料 抽象工厂
 * 负责生产产品族，在这里是原料
 * @author huangy on 2019-05-19
 */
public abstract class PizzaIngredientFactory {

    /**
     * 生成 面团
     */
    public Dough createDough() {

        Dough dough;

        System.out.println("before createDough one");

        System.out.println("before createDough two");

        dough = createDoughSub();

        System.out.println("before createDough three");

        return dough;
    }

    /**
     * 由具体子类 决定生成怎样的面团
     */
    abstract Dough createDoughSub();

    /**
     * 生产酱料
     */
    abstract Sauce createSauce();

    /**
     * 生成奶酪
     */
    abstract Cheese createCheese();
}
