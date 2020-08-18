package huangy.head_first.adapter_pattern;

/**
 * 适配器（将火鸡转变成鸭子）
 * @author huangy on 2019-05-26
 */
public class TurkeyAdapter implements Durk {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
