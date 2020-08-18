package huangy.head_first.iterator_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class DemoTest {

    public static void main(String[] args) {
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(dinerMenu);

        waitress.printMenu();
    }

}
