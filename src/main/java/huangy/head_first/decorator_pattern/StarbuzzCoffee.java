package huangy.head_first.decorator_pattern;

/**
 * @author huangy on 2019-05-19
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        Mocha mocha = new Mocha(beverage);

        System.out.println(mocha.getDescription());

        System.out.println(mocha.cost());
    }

}
