package mango.designpattern.observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private float maxTemp;
    private float minTemp;
    private float sumTemp;
    private int readingCount;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
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
    public void update(float pressure, float temperature, float humidity) {
        // TODO Auto-generated method stub
        updateTemp(temperature);
        display();
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
