package designpattern.strategy;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlyBehavior cantFly = () -> System.out.println("I can't fly");
		QuackBehavior squeak = () -> System.out.println("Squeak");

		MallardDuck mallard = new MallardDuck();
		RedheadDuck redhead = new RedheadDuck();
		RubberDuck rubber = new RubberDuck();

		mallard.display();
		mallard.performFly();
		mallard.performQuack();

		redhead.display();
		redhead.performFly();
		redhead.performQuack();

		rubber.display();
		rubber.performFly();
		rubber.performQuack();
		rubber.setFlyBehavior(cantFly);
		rubber.setQuackBehavior(squeak);
		rubber.performFly();
		rubber.performQuack();

	}

}
