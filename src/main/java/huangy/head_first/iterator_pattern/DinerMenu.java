package huangy.head_first.iterator_pattern;

/**
 * 餐厅菜单
 * @author huangy on 2019-06-07
 */
public class DinerMenu {

    private MenuItem[] menuItems;

    {
        menuItems = new MenuItem[3];
        menuItems[0] = new MenuItem("name1", "desc1", true, 1);
        menuItems[1] = new MenuItem("name2", "desc2", false, 2);
        menuItems[2] = new MenuItem("name3", "desc3", true, 3);
    }

    /**
     * 返回迭代器接口
     * （1）客户不需要知道餐厅菜单是如何维护菜单项的，也不需要知道迭代器是如何实现的。
     * 客户只需要使用这个迭代器遍历元素就可以了。
     */
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
