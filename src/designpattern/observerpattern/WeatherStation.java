package designpattern.observerpattern;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// these classes implement the observer pattern
//		WeatherData weatherData = new WeatherData();
//		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
//		StatisticsDisplay staticticsDisplay = new StatisticsDisplay(weatherData);
//		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		

		// these classes using build-in observer pattern in Java
		WeatherData2 weatherData = new WeatherData2();
		CurrentConditionsDisplay2 currentDisplay = new CurrentConditionsDisplay2(weatherData);
		StatisticsDisplay2 staticticsDisplay = new StatisticsDisplay2(weatherData);
		ForecastDisplay2 forecastDisplay = new ForecastDisplay2(weatherData);
		
		
		// set pressure - temperature - humidity
		weatherData.setMeasurements(30.4f, 80, 65);
		weatherData.setMeasurements(29.8f, 60, 65);
		weatherData.setMeasurements(25.0f, 65, 65);
		weatherData.setMeasurements(40.2f, 72, 65);
	}

}
