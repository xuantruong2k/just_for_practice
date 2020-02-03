package designpattern.observerpattern;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay staticticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		// set pressure - temperature - humidity
		weatherData.setMeasurements(30.4f, 80, 65);
		weatherData.setMeasurements(29.8f, 60, 65);
		weatherData.setMeasurements(25.0f, 65, 65);
		weatherData.setMeasurements(40.2f, 72, 65);
	}

}
