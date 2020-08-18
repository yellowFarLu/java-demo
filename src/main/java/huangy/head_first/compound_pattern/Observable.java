package huangy.head_first.compound_pattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 辅助类
 * 将观察者注册、通知观察者的代码封装起来
 * @author huangy on 2019-06-09
 */
public class Observable implements QuackObservable {

    // 观察者
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(Quackable duck) {
        Iterator<Observer> iterator = observers.iterator();

        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }
}
