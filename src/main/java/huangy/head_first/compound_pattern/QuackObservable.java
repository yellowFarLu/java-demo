package huangy.head_first.compound_pattern;

/**
 * @author huangy on 2019-06-09
 */
public interface QuackObservable {

    void registerObserver(Observer observer);

    void notifyObservers(Quackable duck);
}
