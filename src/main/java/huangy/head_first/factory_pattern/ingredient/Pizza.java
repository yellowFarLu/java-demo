package huangy.head_first.factory_pattern.ingredient;

/**
 * 比萨 实例改写，主要是新增了原料的准备
 * @author huangy on 2019-05-19
 */
public abstract class Pizza {

    Dough dough;

    Sauce sauce;

    Cheese cheese;

    /**
     * 搜集比萨的原料，具体做法交给 PizzaIngredientFactory
     */
    abstract void prepare();

    public void bake() {
        System.out.println("bake");
    }

    public void cut() {
        System.out.println("cut");
    }

    public void box() {
        System.out.println("box");
    }
}
