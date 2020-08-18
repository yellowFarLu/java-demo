package huangy.hyinterface;

/**
 * @author huangy on 2019-04-06
 */
public class Holder<T> {

    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<? super Apple> holder = new Holder<>();
        holder.set(new Apple());
//        holder.set(new Fruit());
//        holder.set(new Object());

        Object tem = holder.get();
    }

    private void func1() {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);

//        Holder<Fruit> fruit = apple;

        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();

        try {
            Orange c = (Orange)fruit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        fruit.set(new Apple());

        System.out.println(fruit.equals(d));
    }
}
