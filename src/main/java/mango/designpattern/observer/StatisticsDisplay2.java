package mango.designpattern.observer;

import java.util.Observable;

public class StatisticsDisplay2 implements java.util.Observer, DisplayElement {

    private Observable observable;
    private float maxTemp;
    private float minTemp;
    private float sumTemp;
    private int readingCount;

    public StatisticsDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
        maxTemp = 0.0f;
        minTemp = 200.0f;
        sumTemp = 0.0f;
        readingCount = 0;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        float avgTemp = calculateAverageTemperature();
        System.out.println("Statistics display - average temperature: " + avgTemp + ", min temp: " + minTemp + ", max temp: " + maxTemp);

    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData2) {
            WeatherData2 data = (WeatherData2)obs;
            updateTemp(data.getTemperature());
            display();
        }
    }

    private void updateTemp(float temperature) {
        readingCount++;
        sumTemp += temperature;
        if (maxTemp < temperature) {
            maxTemp = temperature;
        }
        if (minTemp > temperature) {
            minTemp = temperature;
        }
    }

    private float calculateAverageTemperature() {
        return (sumTemp / readingCount);
    }
}
