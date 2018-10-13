import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task2 {
    public static void main(String[] args) {
        Counter counter = new AtomicLock();
        syncThread increment = new syncThread(counter, true);
        syncThread decrement = new syncThread(counter, false);

        increment.start();
        decrement.start();
    }
}

class syncThread extends Thread {
    private Counter counter;
    private boolean increment;


    public syncThread(Counter counter, boolean increment) {
        this.counter = counter;
        this.increment = increment;
    }

    public void run() {
        if (increment)
            for (int i = 0; i < 100000; i++)
                counter.increment();
        else for (int j = 0; j < 100000; j++)
            counter.decrement();
    }
}

interface Counter{
    void increment();
    void decrement();
}

class SynchronizedCounter implements Counter{
    private int value = 0;

    public synchronized void increment() {
        value++;
        System.out.println(value);
    }

    public synchronized void decrement() {
        value--;
        System.out.println(value);
    }
}

class LockCounter implements Counter{
    private int value = 0;
    private final Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        value++;
        System.out.println(value);
        lock.unlock();
    }

    public void decrement(){
        lock.lock();
        value--;
        System.out.println(value);
        lock.unlock();
    }
}

class AtomicLock implements Counter{
    AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        System.out.println(value.incrementAndGet());
    }

    public void decrement() {
        System.out.println(value.decrementAndGet());
    }
}

