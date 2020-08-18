package huangy.head_first.componet_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单
 * @author huangy on 2019-06-08
 */
public class Menu extends MenuComponent {

    // 存放孩子节点的集合
    private List<MenuComponent> menuComponents = new ArrayList<>();

    private String name;

    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(this);

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
