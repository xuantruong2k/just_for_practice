package udemy.multithreading.threadcreation;

public class AppMain {

    public static void main(String[] args) {
//        AppMain.run1();
        AppMain.run2();
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
}
