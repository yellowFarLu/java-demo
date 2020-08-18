package huangy.head_first.observer_pattern.demo2;


/**
 * @author huangy on 2019-05-19
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(1,2, 3);
    }

}
