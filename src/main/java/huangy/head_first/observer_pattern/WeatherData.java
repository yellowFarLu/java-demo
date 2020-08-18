package huangy.head_first.observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherData对象追踪来自气象站的数据，并且更新布告板
 * @author huangy on 2019-05-19
 */
public class WeatherData implements Subject {

    private float temperature;

    private float humidity;

    private float pressure;

    /**
     * 观察者列表
     */
    private List<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }


    /**
     * 一旦气象站测量更新，该方法将被调用
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 获取温度
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * 获取湿度
     */
    public float getHumidity() {
        return humidity;
    }

    /**
     * 获取气压
     */
    public float getPressure() {
        return pressure;
    }

    /**
     * 模拟气象站给WeatherData对象相关气象数据
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
