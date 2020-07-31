package designpattern.strategy;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        // TODO Auto-generated method stub
        System.out.println("I'm a red head duck");
    }

}
