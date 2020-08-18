package huangy.head_first.componet_pattern;

/**
 * @author huangy on 2019-06-08
 */
public class DemoTest {

    public static void main(String[] args) {
        MenuComponent paMenu = new Menu("pa", "pa");

        MenuComponent diMenu = new Menu("di", "di");
        diMenu.add(new MenuItem("subDi", "subDi", true, 1.1));
        MenuComponent deMenu = new Menu("de", "de");
        diMenu.add(deMenu);
        deMenu.add(new MenuItem("subDe", "subDe", true, 1.578));

        MenuComponent caMenu = new Menu("ca", "ca");

        MenuComponent allMenus = new Menu("all", "all");

        allMenus.add(paMenu);
        allMenus.add(diMenu);
        allMenus.add(caMenu);


        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }

}
