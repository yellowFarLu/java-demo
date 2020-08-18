package huangy.hyinterface;

import java.lang.reflect.*;
import java.util.*;

class Apply
{
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method method, Object...args)
    {
        try{
            for(T obj : seq) {
                method.invoke(obj, args);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate(){
        System.out.println(this + "rotate");
    }

    public void resize(int newSize){
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape{}

class FilledList<T> extends ArrayList<T>
{
    public FilledList(Class<? extends T> type, int size){
        try{
            for(int i=0; i < size; i++){
                add(type.newInstance());
            }
        }catch(Exception e){
            //System.out.println(e);
            throw new RuntimeException(e);
            //RuntimeException标志着程序员的错误
        }
    }
}
//class SimpleQueue<T> implements Iterable<T>{
//    //自定义实现了Iterable接口的类
//    private LinkedList<T> storage = new LinkedList<T>();
//    public void add(T t){storage.offer(t);}
//    public T get(){return storage.poll();}
//    public Iterator<T> iterator(){
//        return storage.iterator();
//    }
//}

public class ApplyTest {

    public static void main(String[] args)throws Exception{

        List<Shape> shapes = new ArrayList<Shape>();
        for(int i=0; i<10; i++){
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));

        Apply.apply(shapes, Shape.class.getMethod("resize",int.class),5);

        List<Square> squares = new ArrayList<Square>();
        for(int i=0; i<10; i++){
            squares.add(new Square());
        }
        Apply.apply(squares, Shape.class.getMethod("rotate"));

        Apply.apply(squares, Shape.class.getMethod("resize",int.class),5);

        Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));

        Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));

        SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
        for(int i=0; i<5 ;i++){
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
    }
}
