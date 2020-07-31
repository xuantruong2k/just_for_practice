package mango.atomic;

public class Counter extends Thread {

    long count = 0;

    public synchronized void run()
    // public void run()
    {
        long max = 2000000000l;

        // increment the counter total of max times
        for (long i = 0; i < max; i++) {
            count++;
        }
    }
}
