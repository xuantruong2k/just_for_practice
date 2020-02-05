package designpattern.strategy;

public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flying with a powered rocket");
	}
}
