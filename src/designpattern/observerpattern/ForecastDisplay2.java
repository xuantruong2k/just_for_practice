package designpattern.observerpattern;

import java.util.Observable;

public class ForecastDisplay2 implements java.util.Observer, DisplayElement {

	private Observable observable;
	private float currPressure;
	private float lastPressure;

	public ForecastDisplay2(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);

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
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData2) {
			WeatherData2 data = (WeatherData2)obs;
			lastPressure = currPressure;
			currPressure = data.getPressure();
			display();
		}
	}

}
