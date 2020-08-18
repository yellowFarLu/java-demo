package huangy.head_first.observer_pattern;

/**
 * 观察者
 * @author huangy on 2019-05-19
 */
public interface Observer {

    /**
     * 观察者接口，主题通过该方法，将一些数据传递给观察者
     */
    void update(float temperature, float humidty, float pressure);

}
