public class Task3 {
    public static void main(String[] args) {
        Counter counter = new Counter();
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

class Counter {
    private int value = 0;

    public /*synchronized*/ void increment() {
        value++;
        System.out.println(value);
    }

    public /*synchronized*/ void decrement() {
        value--;
        System.out.println(value);
    }
}

