package mango.udemy.multithreading.thread.creation.example1;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class AppMain {

    public static void main(String[] args) {
//        AppMain.run1();
//        AppMain.run2();
//        Thread thread = new NewThread();
//        thread.start();

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(Vault.MAX_PASSWORD));

        List<Thread> threads = new ArrayList<Thread>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for (Thread thread : threads) {
            thread.start();
        }
    }

    /**
     * [fundamental] create a simple thread, set name and priority to thread
     */
    public static void run1() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // code will run in a new thread
//                System.out.println("We are now in thread: " + Thread.currentThread().getName());
//                System.out.println("Current thread's priority: " + Thread.currentThread().getPriority());
//            }
//        });

        // using lambda
        Thread thread = new Thread(() -> {
            // code will run in a new thread
            System.out.println("We are now in thread [ " + Thread.currentThread().getName() + " ]");
            System.out.println("Current thread's priority: " + Thread.currentThread().getPriority());
        });

        thread.setName("New worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread [ " + Thread.currentThread().getName() + " ] before starting a new thread");
        thread.start();
        System.out.println("We are in thread [ " + Thread.currentThread().getName() + " ] after starting a new thread");
    }

    /**
     * [fundamental] handler uncaught exception
     */
    public static void run2() {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setName("Misbehaving thread");
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("A critical error happened in thread [ " + t.getName() + " ],"
                + " the error is: " + e.getMessage());
        });

        thread.start();
    }

    public static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from thread: " + this.getName());
        }
    }


}
