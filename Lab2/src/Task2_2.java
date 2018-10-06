import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            writingThread2 pipeT = new writingThread2("|");
            writingThread2 minusT = new writingThread2("-");

            pipeT.start();
            minusT.start();

            pipeT.join();
            minusT.join();
            System.out.println();
        }
    }
}

class writingThread2 extends Thread {
    final static int SYMBOLS_IN_LINE = 20;
    static final Object object = new Object();
    private String symbol;

    public writingThread2(String s) {
        this.symbol = s;

    }

    public void run() {
        try {
                for (int i = 0; i < SYMBOLS_IN_LINE; i++)
                    synchronized (object) {
                        System.out.print(symbol);
                        object.notify();
                        if (i < SYMBOLS_IN_LINE - 1)
                            object.wait();
                    }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
