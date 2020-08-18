package huangy.hyinterface;

/**
 * @author huangy on 2019-04-06
 */
public class GenericHolder<T> {

    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.set("item");
        String s = holder.getObj();
    }
}
