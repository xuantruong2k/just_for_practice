package mango.atomic;

public class AppMain {

    public static void main(String[] args) {

        long lastTime = System.currentTimeMillis();

        try {
            // AppMain.runUnsafeCounter();
            AppMain.runAtomicCounter();
        } catch (Exception ex) {
            System.out.println("message: " + ex.getMessage());
        }

        long duration = (System.currentTimeMillis() - lastTime);

        System.out.println("time to finish (millisecond): " + duration);
    }


    public static void runUnsafeCounter() throws InterruptedException
    {
        Counter counter = new Counter();

        // init threads
        Thread first = new Thread(counter, "first");
        Thread second = new Thread(counter, "second");

        // start threads
        first.start();
        second.start();

        // main thread will wait for both threads to get completed
        first.join();
        second.join();

        // print the counter to screen
        System.out.println(counter.count);
    }


    public static void runSynchronizedCounter() throws InterruptedException
    {
        runUnsafeCounter();
    }

    public static void runAtomicCounter() throws InterruptedException
    {
        AtomicCounter counter = new AtomicCounter();

        // init threads
        Thread first = new Thread(counter, "first");
        Thread second = new Thread(counter, "second");

        // start threads
        first.start();
        second.start();

        // main thread will wait for both threads to get completed
        first.join();
        second.join();

        // print the counter to screen
        System.out.println(counter.count);
    }

}
