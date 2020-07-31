package designpattern.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private float pressure;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Current conditions display - temperature: " + temperature
                + ", pressure: " + pressure + ", humidity: " + humidity);
    }

    @Override
    public void update(float pressure, float temperature, float humidity) {
        // TODO Auto-generated method stub
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

}
