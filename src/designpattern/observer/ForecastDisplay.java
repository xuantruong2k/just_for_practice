package designpattern.observer;

public class ForecastDisplay implements Observer, DisplayElement {

	private Subject weatherData;
	private float currPressure;
	private float lastPressure;

	public ForecastDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);

		currPressure = 29.9f;
		lastPressure = 0.0f;
	}

	@Override
	public void display() {
		String tmpStr = "";
		if (currPressure > lastPressure) { // more chance for sunny
			tmpStr = "More change for sunny on next day";
		} else if (currPressure < lastPressure) { // more change for rainy
			tmpStr = "Watchout of the rain, don't forget to take an umbrealla when goes out";
		} else { // currPressure == lastPressure -> the same pressure
			tmpStr = "Next day will be the same as today";
		}

		System.out.println("Forecast display : " + tmpStr);
	}

	@Override
	public void update(float pressure, float temperature, float humidity) {
		lastPressure = currPressure;
		currPressure = pressure;
		display();
	}

}
