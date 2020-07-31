package designpattern.observer;

import java.util.Observable;

/**
 * this class implements observer pattern using default observer build-in support in Java
 *
 */
public class WeatherData2 extends Observable {

    private float pressure;
    private float temperature;
    private float humidity;

    public WeatherData2() {
    }

    public float getPressure() {
        return this.pressure;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public void setMeasurements(float pressure, float temperature, float humidity) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;

        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }
}
