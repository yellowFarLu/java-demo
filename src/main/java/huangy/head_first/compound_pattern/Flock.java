package huangy.head_first.compound_pattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author huangy on 2019-06-09
 */
public class Flock implements Quackable {

    Observable observable;

    public Flock(Observable observable) {
        this.observable = observable;
    }

    // 存储子节点
    ArrayList<Quackable> quackables = new ArrayList<>();

    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    public void quack() {
        Iterator<Quackable> iterator = quackables.iterator();
        while (iterator.hasNext()) {
            Quackable quackable = iterator.next();
            quackable.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers(Quackable quackable) {
        observable.notifyObservers(quackable);
    }
}
