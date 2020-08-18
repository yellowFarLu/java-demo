package huangy.hyreference;

public class StrongReferenceTest {

    public static void main(String[] args) {
        MyDate date = new MyDate();
        System.gc();
    }
}
