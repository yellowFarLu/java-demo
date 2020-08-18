package huangy.jvm.method;

/**
 * @author huangy on 2019-10-27
 */
public class FatherDispath {

    static class QQ {}

    static class _360 {}

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("fahter choice qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("fahter choice 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("Son choice qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("Son choice 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();

        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
