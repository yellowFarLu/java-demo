package huangy.jvm.method;

/**
 * @author huangy on 2019-10-27
 */
public class DynamicDispatch {

    static abstract class Human {
        protected abstract void Hello();
    }

    static class Man extends Human {
        @Override
        protected void Hello() {
            System.out.println("man say Hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void Hello() {
            System.out.println("Woman say Hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.Hello();
        woman.Hello();

        man = woman;
        man.Hello();
    }
}
