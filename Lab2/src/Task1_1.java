import java.util.Scanner;

public class Task1_1 {
    public static void main(String[] args) throws InterruptedException {
        final int LINES_COUNT = 100;

        for (int i = 0; i < LINES_COUNT; i++) {
            writingThread pipeT = new writingThread("|");
            writingThread minusT = new writingThread("-");

            pipeT.start();
            minusT.start();

            pipeT.join();
            minusT.join();

            System.out.println();
        }
    }
}

class writingThread extends Thread {
    final static int SYMBOLS_IN_LINE = 50;

    private String symbol;

    public writingThread(String s) {
        this.symbol = s;
    }

    public void run() {
        for (int i = 0; i < SYMBOLS_IN_LINE; i++) {
            System.out.print(symbol);
        }
    }
}
