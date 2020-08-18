package huangy.hyinterface;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangy on 2019-04-06
 */
public class GenericReading {

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);

        // hyinterface.GenericReading.readExact是泛型方法，在使用方法时才确定参数类型
        f = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        // hyinterface.GenericReading.Reader是泛型类，在使用这个类的时候，就确定好参数类型了
        Reader<Fruit> fruitReader = new Reader<>();

        Fruit f = fruitReader.readExact(fruits);

        /*
         * 既然确定好T是Fruit，那么hyinterface.GenericReading.Reader.readExact只接收List<Fruit>类型的参数，
         * 自然就不接受List<Apple>的参数了
         */
//        Fruit a = fruitReader.readExact(apples);
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
