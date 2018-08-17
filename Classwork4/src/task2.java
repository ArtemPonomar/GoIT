import java.util.Scanner;

public class task2 {

    public static  int toSec(int a, int b, int c)
    {
        return (3600*a + 60*b + c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h1 = in.nextInt();
        int m1 = in.nextInt();
        int s1 = in.nextInt();

        int h2 = in.nextInt();
        int m2 = in.nextInt();
        int s2 = in.nextInt();

        int S1 = toSec(h1, m1, s1);
        int S2 = toSec(h2, m2, s2);

        int total = S2 - S1;

        int h = total - total%3600;
        total -= h;

        int m = total - total%60;
        total -= m;

        int s = total;

        System.out.println(h/3600 + " " + m/60 + " " + s);
    }
}
