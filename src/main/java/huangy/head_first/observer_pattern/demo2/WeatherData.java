package huangy.head_first.observer_pattern.demo2;

import java.util.Observable;

/**
 * @author huangy on 2019-05-19
 */
public class WeatherData extends Observable {

    private float temperature;

    private float humidity;

    private float pressure;

    /**
     * 一旦气象站测量更新，该方法将被调用
     */
    public void measurementsChanged() {
        // 改变标志位，表示可以进行通知
        setChanged();

        /**
         * 通知观察者
         * 这里没有直接传递参数，表示这里只是告诉观察者数据已经变更了，你们可以根据需要自己去拿数据
         */
        notifyObservers();
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
}
