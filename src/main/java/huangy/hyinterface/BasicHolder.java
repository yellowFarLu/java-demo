package huangy.hyinterface;

/**
 * @author huangy on 2019-04-07
 */
public class BasicHolder<T> {
    T element;

    public T get() {
        return element;
    }

    public void set(T element) {
        this.element = element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
