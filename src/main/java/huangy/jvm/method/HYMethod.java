package huangy.jvm.method;

/**
 * @author huangy on 2019-10-27
 */
public class HYMethod {

    public static void func(Super superz) {
        System.out.println("super");
    }

    public static void func(Man man) {
        System.out.println("man");
    }

    public static void func(Woman woman) {
        System.out.println("woman");
    }

    public static void main(String[] args) {
        Super superz = new Man();
        func(superz);

        char a = '1';
        byte b = (byte)a;
    }
}

abstract class Super {}

class Man extends Super { }

class Woman extends Super {}

