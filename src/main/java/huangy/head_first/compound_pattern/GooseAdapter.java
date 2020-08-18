package huangy.head_first.compound_pattern;

import huangy.head_first.compound_pattern.ducks.Goose;

/**
 * 适配器，把鹅适配成鸭子
 * @author huangy on 2019-06-09
 */
public class GooseAdapter implements Quackable {

    Observable observable;

    Goose goose;

    public GooseAdapter(Observable observable, Goose goose) {
        this.observable = observable;
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void notifyObservers(Quackable quackable) {
        observable.notifyObservers(quackable);
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }
}
