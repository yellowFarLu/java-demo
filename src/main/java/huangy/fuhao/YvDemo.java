package huangy.fuhao;

/**
 * @author huangy on 2019-10-10
 */
public class YvDemo {

    private static boolean func1() {
        System.out.println("func1");
        return false;
    }

    private static boolean func2() {
        System.out.println("func2");
        return false;
    }

    public static void main(String[] args) {
        if (func1() || func2()) {

        }


        System.out.println("________________________");

        if (func1() | func2()) {

        }
    }

}
