package huangy.hyinterface;

import java.util.*;

/**
 * SimpleQueue、Collection两种没有实现特定接口的方法，
 * 通过适配器的方式，能够不区分具体类型的情况下，调用相同的方法
 */


//首先我们定义一个咖啡的基类
class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}

/*
然后我们定义一串咖啡的子类Latte，Mocha之类的，这个地方为了不让代码太长，所以我不写出来。
*/
class Latte extends Coffee {

}

class Mocha extends Coffee {

}


//下面就是比较复杂的部分了
interface Addable<T>{ void add(T t); }

class Fill2 {
    //将fill方法重载，参数为(实现Addable接口的类，类，大小)
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken,int size){
        for(int i=0; i<size; i++){
            try{
                addable.add(classToken.newInstance());
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    //将fill方法重载，参数为(实现Addable接口的类，实现了Generator的对象，大小)
    /*
    public static <T> void fill(Addable<T> addable, Generator<T> generator,int size){
        addable.add(generator.next());
    }
    *///很可惜这个方法并没有用上
}

class AddableCollectionAdapter<T> implements Addable<T>
{
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }
    public void add(T item){
        //实现Addable接口中的add方法
        c.add(item);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}

class SimpleQueue<T> implements Iterable<T>{
    private LinkedList<T> storage = new LinkedList<T>();
    public void add(T t){storage.offer(t);}
    public T get(){return storage.poll();}
    public Iterator<T> iterator(){
        return storage.iterator();
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    //使用适配器模式只不过这个地方还是覆盖了基类SimpleQueue中的add方法
    public void add(T item){
        super.add(item);
    }
}

public class Fill2Test
{
    public static void main(String[] args){
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(
                new AddableCollectionAdapter<Coffee>(carrier),
                Coffee.class,
                3);
        Fill2.fill(
                Adapter.collectionAdapter(carrier),
                Latte.class,
                2);
        for(Coffee c: carrier)
            print(c);

        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for(Coffee c: coffeeQueue)
            print(c);
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
