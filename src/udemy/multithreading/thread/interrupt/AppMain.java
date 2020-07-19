package udemy.multithreading.thread.interrupt;

import java.math.BigInteger;

public class AppMain {

    public static void main(String[] args) {
//        Thread thread = new Thread(new BlockingTask());
//        thread.start();
//        thread.interrupt();

        Thread thread = new Thread(new LongComutationTask(BigInteger.valueOf(10000), BigInteger.valueOf(100000)));

        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    public static class BlockingTask implements Runnable {
        @Override
        public void run() {
            // do things
            try {
                Thread.sleep(50000);
            } catch (InterruptedException ex) {
                System.out.println("Exiting the blocking thread");
            }
        }
    }

    private static class LongComutationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComutationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Prematurely interrupted computation");
//                    return BigInteger.ZERO;
//                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
