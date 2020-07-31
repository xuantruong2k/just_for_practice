package udemy.multithreading.thread.calculation;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result = BigInteger.ZERO;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

        // setDeamon need to be set before start thread
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();

        try {
            thread1.join(2000);
            thread2.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = thread1.getResult().add(thread2.getResult());

        System.out.println("result is: " + result);
        return result;
    }


    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = pow(base, power);
        }

        // implement the calculation of result = base ^ power
        public BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger tempResult = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                tempResult = tempResult.multiply(base);
            }

            return tempResult;
        }

        public BigInteger getResult() { return result; }
    }
}
