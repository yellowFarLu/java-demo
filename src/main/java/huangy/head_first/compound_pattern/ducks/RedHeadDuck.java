package huangy.head_first.compound_pattern.ducks;

import huangy.head_first.compound_pattern.Observable;
import huangy.head_first.compound_pattern.Observer;
import huangy.head_first.compound_pattern.Quackable;

/**
 * 红头鸭
 * @author huangy on 2019-06-09
 */
public class RedHeadDuck implements Quackable {

    Observable observable;

    public RedHeadDuck(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void quack() {
        System.out.println("RedHeadDuck quack");
         notifyObservers(this);
    }

    @Override
    public void notifyObservers(Quackable duck) {
        observable.notifyObservers(duck);
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }
}
