import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) throws InterruptedException {
         writingThread pipeT = new writingThread("|");
         writingThread minusT = new writingThread("-");

         pipeT.start();
         minusT.start();
    }
}

class writingThread extends Thread {
    private String symbol;

    public writingThread(String s) {
        this.symbol = s;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(symbol);
        }
    }
}
