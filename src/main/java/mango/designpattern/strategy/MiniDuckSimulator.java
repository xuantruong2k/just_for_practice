package mango.designpattern.strategy;

public class MiniDuckSimulator {

    public void run() {

        FlyBehavior cantFly = new FlyBehavior() {
            @Override
            public void fly() {
                System.out.println("I can't fly");
            }
        };
        QuackBehavior squeak = new QuackBehavior() {
            @Override
            public void quack() {
                System.out.println("Squeak");
            }
        };

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
