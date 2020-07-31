package mango.designpattern.observer;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private float pressure;
    private float temperature;
    private float humidity;

    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<Observer> ();
    }

    @Override
    public void registerObserver(Observer ob) {
        // TODO Auto-generated method stub
        // check to make sure the Observer has not been the array before
        int idx = observers.indexOf(ob);
        if (idx == -1) {
            observers.add(ob);
        }
    }

    @Override
    public void removeObserver(Observer ob) {
        // TODO Auto-generated method stub
        int idx = observers.indexOf(ob);
        if (idx > 0) {
            observers.remove(idx);
        }
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        for (Observer ob : observers) {
            ob.update(pressure, temperature, humidity);
        }
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

    public void setPressure(float val) {
        this.pressure = val;
    }

    public void setTemperature(float val) {
        this.temperature = val;
    }

    public void setHumidity(float val) {
        this.humidity = val;
    }

    public void setMeasurements(float pressure, float temperature, float humidity) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;

        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObservers();
    }
}
