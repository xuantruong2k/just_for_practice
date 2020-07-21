package udemy.multithreading.thread.data.sharing;

import java.util.concurrent.atomic.AtomicInteger;

public class AppMain {

    public static int MAX_ITEMS = 10000000;

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        long startTime = System.currentTimeMillis();

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Current number of items: " + inventoryCounter.getItems() + ", duration: " + String.valueOf(endTime - startTime));
    }

    private static class IncrementingThread extends Thread {
        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_ITEMS; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class DecrementingThread extends Thread {
        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_ITEMS; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    private static class InventoryCounter {
        private AtomicInteger items = new AtomicInteger(0);

        Object lock = new Object();

        public void increment() {
            items.incrementAndGet();
//            synchronized (lock) {
//                items++;
//            }
        }

        public void decrement() {
            items.decrementAndGet();
//            synchronized (lock) {
//                items--;
//            }
        }

        public int getItems() {
            return items.get();
//            synchronized (lock) {
//                return items;
//            }
        }
    }
}
