package designpattern.observerpattern;

public interface Subject {
	public void registerObserver(Observer ob);
	public void removeObserver(Observer ob);
	public void notifyObservers();
}
