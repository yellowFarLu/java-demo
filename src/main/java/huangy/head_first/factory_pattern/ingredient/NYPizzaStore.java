package huangy.head_first.factory_pattern.ingredient;

/**
 * @author huangy on 2019-05-19
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {

        PizzaIngredientFactory pizzaIngredientFactory =
                new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            return new CheesePizza(pizzaIngredientFactory);
        }

        return null;
    }
}