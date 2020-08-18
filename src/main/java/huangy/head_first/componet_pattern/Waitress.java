package huangy.head_first.componet_pattern;

/**
 * 女招待员（客户）
 * @author huangy on 2019-06-08
 */
public class Waitress {

    // 相当于根节点
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
