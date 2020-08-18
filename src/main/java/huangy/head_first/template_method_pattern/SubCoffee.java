package huangy.head_first.template_method_pattern;

/**
 * @author huangy on 2019-06-05
 */
public class SubCoffee extends Coffee {

    @Override
    public void pourInCup() {
        System.out.println("sub pourInCup");
    }

    @Override
    public void addSugarAndMik() {
        super.addSugarAndMik();
        System.out.println("sub addSugarAndMik");
    }
}
