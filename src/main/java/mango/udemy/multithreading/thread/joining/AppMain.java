package mango.udemy.multithreading.thread.joining;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(10000000L, 3435L, 12345L, 2345L, 23L, 45678L);

        List<FactorialThread> threads = new ArrayList<>();

        // create threads
        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        // start threads
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        // joining threads
        for (Thread thread : threads) {
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {

        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = n; i > 0; i--) {
//                tempResult = tempResult.multiply(BigInteger.valueOf(i));
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }

            return tempResult;
        }

        public BigInteger getResult() {
            return this.result;
        }

        public boolean isFinished() {
            return this.isFinished;
        }
    }

}
