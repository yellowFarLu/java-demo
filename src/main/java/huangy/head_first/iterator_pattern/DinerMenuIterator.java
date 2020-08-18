package huangy.head_first.iterator_pattern;

/**
 * 菜单项迭代器
 * @author huangy on 2019-06-07
 */
public class DinerMenuIterator implements Iterator {

    MenuItem[] items;

    int position;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        return ((position < items.length) && (items[position] != null));
    }
}
