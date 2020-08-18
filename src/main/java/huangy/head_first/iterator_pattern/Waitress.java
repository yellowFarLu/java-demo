package huangy.head_first.iterator_pattern;

/**
 * 女招待员
 * @author huangy on 2019-06-08
 */
public class Waitress {

    DinerMenu dinerMenu;

    public Waitress(DinerMenu dinerMenu) {
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator iterator = dinerMenu.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
