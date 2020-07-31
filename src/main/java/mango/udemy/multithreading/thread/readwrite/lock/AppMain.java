package mango.udemy.multithreading.thread.readwrite.lock;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AppMain {

    /*
        There are total 8 threads: 1 writer thread & 7 reader threads.
        The ReentrantReadWriteLock only takes advantage when there
         are many reader thread over writer thread.
         -> If many writer thread over reader thread?

        + using ReentrantLock, took 3408 ms
        + using ReentrantReadWriteLock, took 745 ms
     */

    public static final int HIGHEST_PRICE = 1000;
    public static final int MAX_ITEM_COUNT = 100000;

    public static void main(String[] args) throws InterruptedException {

        // create and add items to inventory
        InventoryDataBase inventoryDataBase = new InventoryDataBase();
        Random random = new Random();
        for (int i = 0; i < MAX_ITEM_COUNT; i++) {
            inventoryDataBase.addItem(random.nextInt(HIGHEST_PRICE));
        }

        // create writer thread
        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    inventoryDataBase.addItem(random.nextInt(HIGHEST_PRICE));
                    inventoryDataBase.removeItem(random.nextInt(HIGHEST_PRICE));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        writer.setDaemon(true);
        writer.start();

        // create reader threads
        int numberOfReaderThreads = 7;
        List<Thread> readers = new ArrayList<>();
        for (int readerIdx = 0; readerIdx < numberOfReaderThreads; readerIdx++) {
            Thread reader = new Thread(() -> {
                for (int i = 0; i < MAX_ITEM_COUNT; i++) {
                    int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
                    int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;
                    inventoryDataBase.getNumberOfItemsInPriceRange(lowerBoundPrice, upperBoundPrice);
                }
            });

            reader.setDaemon(true);
            readers.add(reader);
        }

        long startingReadingTime = System.currentTimeMillis();
        for (Thread readerThread : readers) {
            readerThread.start();
        }

        for (Thread readerThread : readers) {
            readerThread.join(); // waiting for thread complete
        }
        long endingReadingTime = System.currentTimeMillis();

        System.out.println(String.format("Reading took %d ms", endingReadingTime - startingReadingTime));
    }

    public static class InventoryDataBase {

        private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();

        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        private Lock readLock = reentrantReadWriteLock.readLock();
        private Lock writeLock = reentrantReadWriteLock.writeLock();
        private Lock reentrantLock = new ReentrantLock();

        public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
//            reentrantLock.lock();
            readLock.lock();
            try {
                Integer fromKey = priceToCountMap.ceilingKey(lowerBound);
                Integer toKey = priceToCountMap.floorKey(upperBound);

                if (fromKey == null || toKey == null)
                    return 0;

                NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

                int sum = 0;
                for (int numberOfItemsForPrice : rangeOfPrices.values()) {
                    sum += numberOfItemsForPrice;
                }
                return sum;

            } finally {
//                reentrantLock.unlock();
                readLock.unlock();
            }
        }

        public void addItem(int price) {
//            reentrantLock.lock();
            writeLock.lock();
            try {
                Integer numberOfItemsForPrice = priceToCountMap.get(price);
                if (numberOfItemsForPrice == null) {
                    priceToCountMap.put(price, 1);
                } else {
                    priceToCountMap.put(price, numberOfItemsForPrice + 1);
                }
            } finally {
//                reentrantLock.unlock();
                writeLock.unlock();
            }
        }

        public void removeItem(int price) {
//            reentrantLock.lock();
            writeLock.lock();
            try {
                Integer numberOfItemsForPrice = priceToCountMap.get(price);
                if (numberOfItemsForPrice == null || numberOfItemsForPrice == 1) {
                    priceToCountMap.remove(price);
                } else {
                    priceToCountMap.put(price, numberOfItemsForPrice - 1);
                }
            } finally {
//                reentrantLock.unlock();
                writeLock.unlock();
            }
        }
    }
}
