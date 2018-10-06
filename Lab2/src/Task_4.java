import java.util.Random;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        final int ITERATIONS_COUNT = 100;
        int[][] a, b;
        int threadsCount;
        Result result;
        int am, an, bm, bn;

        Scanner scanner = new Scanner(System.in);
        System.out.println("am, an (=bm), bn: ");
        am = scanner.nextInt();
        an = bm = scanner.nextInt();
        bn = scanner.nextInt();

        a = Matrix.generate(am, an);
        b = Matrix.generate(bm, bn);
        result = new Result(am, bn);

//        Matrix.print(a);
//        System.out.println();
//        Matrix.print(b);
//        System.out.println();

        while (true) {
            System.out.println("Threads count: ");
            threadsCount = scanner.nextInt();
            long totalRunTime = 0;
            for (int i = 0; i < ITERATIONS_COUNT; i++) {
                long startTime = System.nanoTime();
                CalcThread.calculate(a, b, threadsCount, result);
                long runTime = System.nanoTime() - startTime;
                totalRunTime += runTime;
            }

            System.out.println(totalRunTime/ITERATIONS_COUNT);

            //Matrix.print(result.arr);
            System.out.println();
        }
    }
}

class CalcThread extends Thread {
    private int[][] a, b;
    private int from, to;
    Result result;

    public CalcThread(int[][] a, int [][] b, Result result, int from, int to){
        this.a = a;
        this.b = b;
        this.result = result;
        this.from = from;
        this.to = to;
    }

    public void run() {
        for (int row = from; row < to; row++)
            for (int column = 0; column < b[0].length; column++) {
                int cur = 0;
                for (int i = 0; i < a[0].length; i++)
                    cur += a[row][i] * b[i][column];
                result.arr[row][column] = cur;
            }
    }

    public static void calculate(int[][] a, int[][] b, int threadsCount, Result result) {
        CalcThread[] threads = new CalcThread[threadsCount];
        int bite = a.length / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new CalcThread(a, b, result, i*bite, i*bite + bite);
            threads[i].start();
    }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e){
        }
    }
}

class Result {
    public int[][] arr;

    public Result(int m, int n) {
        arr = new int[m][n];
    }
}

class Matrix {
    static final int MAX_RAND_ELEMENT = 11;

    public static int[][] generate(int m, int n) {
        Random random = new Random();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(MAX_RAND_ELEMENT);
            }
        }
        return array;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}