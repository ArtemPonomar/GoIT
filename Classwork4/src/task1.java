import java.util.Scanner;

public class task1 {
    public static boolean isMiddle(int a, int b, int c)
    {
        return ((b > a && b < c) || (b > c && b < a));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if(isMiddle(a, b, c)) System.out.println(b);
        else if (isMiddle(b, c, a)) System.out.println(c);
        else System.out.println(a);
    }
}
