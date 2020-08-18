package huangy.head_first.compound_pattern;

/**
 * @author huangy on 2019-06-09
 */
public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist " + duck + " just quack");
    }
}
