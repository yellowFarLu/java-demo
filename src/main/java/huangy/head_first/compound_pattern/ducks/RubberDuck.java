package huangy.head_first.compound_pattern.ducks;

import huangy.head_first.compound_pattern.Observable;
import huangy.head_first.compound_pattern.Observer;
import huangy.head_first.compound_pattern.Quackable;

/**
 * @author huangy on 2019-06-09
 */
public class RubberDuck implements Quackable {

    Observable observable;

    public RubberDuck(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void quack() {
        System.out.println("RubberDuck quack");
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
