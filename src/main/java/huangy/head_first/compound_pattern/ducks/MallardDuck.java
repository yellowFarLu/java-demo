package huangy.head_first.compound_pattern.ducks;

import huangy.head_first.compound_pattern.Observable;
import huangy.head_first.compound_pattern.Observer;
import huangy.head_first.compound_pattern.Quackable;

/**
 * 标准的绿头鸭
 * @author huangy on 2019-06-09
 */
public class MallardDuck implements Quackable {

    // 辅助类
    Observable observable;

    public MallardDuck(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck quack");
        // 鸭子叫的时候，让观察者知道
        notifyObservers(this);
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers(Quackable duck) {
        observable.notifyObservers(duck);
    }
}
