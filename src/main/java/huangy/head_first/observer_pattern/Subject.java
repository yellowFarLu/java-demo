package huangy.head_first.observer_pattern;

/**
 * 主题
 * @author huangy on 2019-05-19
 */
public interface Subject {

    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 删除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
