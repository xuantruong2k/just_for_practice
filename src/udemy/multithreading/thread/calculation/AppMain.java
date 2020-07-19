package udemy.multithreading.thread.calculation;

import java.math.BigInteger;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        complexCalculation.calculateResult(BigInteger.valueOf(1234567890L), BigInteger.valueOf(1000000000L),
                BigInteger.valueOf(54321L), BigInteger.valueOf(10000L));
    }
}
