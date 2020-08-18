package huangy.head_first.observer_pattern.demo2;

import huangy.head_first.observer_pattern.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author huangy on 2019-05-19
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;

            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay, temperature=" + temperature
                + " humidity=" + humidity);
    }
}
