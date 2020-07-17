package teddy.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter extends Thread {

    AtomicLong count;

    public AtomicCounter() {
        count = new AtomicLong();
    }

    public void run()
    {
        long max = 2000000000l;

        // increment the counter total of max times
        for (long i = 0; i < max; i++) {
            count.addAndGet(1l);
        }
    }


}