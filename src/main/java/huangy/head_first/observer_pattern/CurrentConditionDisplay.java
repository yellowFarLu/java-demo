package huangy.head_first.observer_pattern;

/**
 * @author huangy on 2019-05-19
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidty, float pressure) {
        this.temperature = temperature;
        this.humidity = humidty;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay, temperature=" + temperature
        + " humidity=" + humidity);
    }
}
