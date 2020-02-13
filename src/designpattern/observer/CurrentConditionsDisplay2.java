package designpattern.observer;

import java.util.Observable;

public class CurrentConditionsDisplay2 implements java.util.Observer, DisplayElement {

	private Observable observable;
	private float pressure;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay2(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current conditions display - temperature: " + temperature
				+ ", pressure: " + pressure + ", humidity: " + humidity);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData2) {
			WeatherData2 data = (WeatherData2)obs;
			this.pressure = data.getPressure();
			this.temperature = data.getTemperature();
			this.humidity = data.getHumidity();
			display();
		}
	}

}
