package huangy.base;

/**
 * @author huangy on 2019-10-17
 */
public class TryDemo {

    public void func() {
        try {
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("return and finally");
        }
    }

    public static void main(String[] args) {
        new TryDemo().func();
    }

}
