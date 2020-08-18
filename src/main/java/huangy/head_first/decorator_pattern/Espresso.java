package huangy.head_first.decorator_pattern;

/**
 * 浓缩咖啡
 * @author huangy on 2019-05-19
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
