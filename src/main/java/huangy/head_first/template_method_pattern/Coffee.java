package huangy.head_first.template_method_pattern;

/**
 * 抽象类
 * @author huangy on 2019-05-26
 */
public abstract class Coffee {

    /**
     * 定义泡咖啡的过程（定义一个模板方法，封装了一个算法）
     */
    final void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMik();
    }

    public void boilWater() {
        System.out.println("boilWater");
    }

    public void brewCoffeeGrinds() {
        System.out.println("brewCoffeeGrinds");
    }

    /**
     * 怎么倒进被子中，由子类决定
     */
    public abstract void pourInCup();

    /**
     * 声明一个钩子，子类决定要不要实现
     */
    public void addSugarAndMik() {

    }
}
