package huangy.hyinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangy on 2019-04-06
 */
public class FruitDemo {

    private void fun1() {
        // 父类型数组引用可以指向子类型
        Fruit[] fruits = new Apple[10];

        // 可以存放Apple及其派生类的对象
        fruits[0] = new Apple();
        fruits[1] = new Jonthan();

        /*
         * 编译器允许添加Fruit类型的对象，但是在编译器会报错。
         * 因为数组存储的对象类型在数组创建的时候就决定了
         * 只能是Apple及其派生类的类型
         */
        try {
            fruits[2] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fruits[3] = new Orange();
        }  catch (Exception e) {
            e.printStackTrace();
        }

        List<? extends Fruit> arr = new ArrayList<Apple>();
    }

    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<>();
        /*
         * 编译错误
         * 因为一旦执行这种类型的向上转型，就不能添加对象了。
         */
//        flist.add(new Object());
    }
}

class Fruit{}

class Apple extends Fruit {}

class Jonthan extends Apple {}

class Orange extends Fruit {}


