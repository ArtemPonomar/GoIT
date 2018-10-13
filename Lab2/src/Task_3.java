import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        final int ITERATIONS_COUNT = 30;
        int[][] a, b;
        int[] threads = {12, 15, 24, 30, 60, 72, 120, 180, 216, 360, 540, 1080};
        Result result;
        int am, an, bm, bn;

        Scanner scanner = new Scanner(System.in);
//        System.out.println("am, an (=bm), bn: ");
//        am = scanner.nextInt();
//        an = bm = scanner.nextInt();
//        bn = scanner.nextInt();
//
//        a = Matrix.generate(am, an);
//        b = Matrix.generate(bm, bn);

        for (int i = 0; i <= 12; i++) {
            int currentThreadsCount = threads[i];
            int totalTime = 0;

//            b = Matrix.generateTest(100, 100, 1);
//            a = b;
//            am = an = bn = 100;
            result = new Result(1080, 1080);

            for (int j = 0; j < ITERATIONS_COUNT; j++) {

                a = Matrix.generate(1080, 1080);
                b = Matrix.generate(1080, 1080);

                long startTime = System.nanoTime();
                for (int k = 0; k < ITERATIONS_COUNT; k++) {
                    CalcThread.calculate(a, b, currentThreadsCount, result);
                }
                long runTime = System.nanoTime() - startTime;
                totalTime += runTime / ITERATIONS_COUNT;
            }

            System.out.println("for threads count = " + currentThreadsCount + ". Tun time = " + totalTime / ITERATIONS_COUNT);
            //System.out.println(result);

            //System.out.println();

        }
    }
}

class CalcThread extends Thread {
    private int[][] a, b;
    private int from, to;
    Result result;

    public CalcThread(int[][] a, int[][] b, Result result, int from, int to) {
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
            threads[i] = new CalcThread(a, b, result, i * bite, i * bite + bite);
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
        }
    }
}

class Result {
    public int[][] arr;

    public Result(int m, int n) {
        arr = new int[m][n];
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result += arr[i][j] + " ";
            }
            result += "\n";
        }
        return result;
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

    public static int[][] generateTest(int m, int n, int a) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = a;
            }
        }
        return arr;
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