package huangy.head_first.adapter_pattern;

/**
 * 某个火鸡实现
 * @author huangy on 2019-05-26
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("WildTurkey gobble");
    }

    @Override
    public void fly() {
        System.out.println("WildTurkey fly");
    }
}
