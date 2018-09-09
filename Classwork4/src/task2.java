import java.util.Scanner;

public class task2 { //задача номер 2

    public static  int toSec(int a, int b, int c)
    {
        return (3600*a + 60*b + c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = 0;

        if (n == 0) {
            r = 1;
        } else while (n!= 0) {
            n = n/10;
            r++;
        }

        System.out.println(r);
    }
}
