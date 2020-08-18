package huangy.jvm;

/**
 * @author huangy on 2019-10-21
 */
public class InitClassDemo {

    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }

}
