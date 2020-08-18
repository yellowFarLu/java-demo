package huangy.head_first.adapter_pattern;

/**
 * @author huangy on 2019-05-26
 */
public class DuckTest {

    public static void main(String[] args) {
        // 火鸡对象
        WildTurkey wildTurkey = new WildTurkey();

        // 把火鸡对象包装成鸭子
        Durk durk = new TurkeyAdapter(wildTurkey);

        durk.quack();
        durk.fly();
    }

}
