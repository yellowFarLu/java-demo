package huangy.head_first.decorator_pattern;

/**
 * 饮料
 * @author huangy on 2019-05-19
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
