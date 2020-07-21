package udemy.multithreading.thread.reentrant.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppMain {

    public static class PricesContainer {
        private Lock lockObject = new ReentrantLock();

        private double btcPrice;
        private double ethPrice;
        private double etcPrice;
        private double ltcPrice;
        private double xrpPrice;

        public Lock getLockObject() {
            return lockObject;
        }

        public double getBtcPrice() {
            return btcPrice;
        }

        public double getEthPrice() {
            return ethPrice;
        }

        public double getEtcPrice() {
            return etcPrice;
        }

        public double getLtcPrice() {
            return ltcPrice;
        }

        public double getXrpPrice() {
            return xrpPrice;
        }

        public void setLockObject(Lock lockObject) {
            this.lockObject = lockObject;
        }

        public void setBtcPrice(double btcPrice) {
            this.btcPrice = btcPrice;
        }

        public void setEthPrice(double ethPrice) {
            this.ethPrice = ethPrice;
        }

        public void setEtcPrice(double etcPrice) {
            this.etcPrice = etcPrice;
        }

        public void setLtcPrice(double ltcPrice) {
            this.ltcPrice = ltcPrice;
        }

        public void setXrpPrice(double xrpPrice) {
            this.xrpPrice = xrpPrice;
        }
    }

    public static class PriceUpdater extends Thread {
        private PricesContainer pricesContainer;
        private Random random = new Random();

        public PriceUpdater(PricesContainer pricesContainer) {
            this.pricesContainer = pricesContainer;
        }

        @Override
        public void run() {
            while (true) {
                pricesContainer.getLockObject().lock();
                try {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    pricesContainer.setBtcPrice(random.nextInt(20000));
                    pricesContainer.setEthPrice(random.nextInt(2000));
                    pricesContainer.setEtcPrice(random.nextInt(50));
                    pricesContainer.setLtcPrice(random.nextInt(500));
                    pricesContainer.setXrpPrice(random.nextDouble());
                }
                finally {
                    pricesContainer.getLockObject().unlock();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
