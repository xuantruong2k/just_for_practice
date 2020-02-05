package designpattern.strategy;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		// TODO Auto-generated method stub
		System.out.println("I'm a mallard duck");
	}

}
