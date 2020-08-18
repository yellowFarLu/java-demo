package huangy.head_first.template_method_pattern;

/**
 * @author huangy on 2019-06-05
 */
public class DemoTest {

    public static void main(String[] args) {
        Coffee subCoffee = new SubCoffee();

        subCoffee.prepareRecipe();
    }

}
