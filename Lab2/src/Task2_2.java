import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) throws InterruptedException {

        writingThread2 pipeT = new writingThread2("|");
        writingThread2 minusT = new writingThread2("-");

        pipeT.start();
        minusT.start();
    }
}

class writingThread2 extends Thread {
    static final Object object = new Object();
    private Counter counter;
    private String symbol;

    public writingThread2(String s, Counter counter) {
        this.symbol = s;

    }

    public void run() {
        try {
                for (int i = 0; i < 10; i++)
                    synchronized (object) {
                        System.out.print(symbol);
                        object.notify();
                        object.wait();
                    }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
