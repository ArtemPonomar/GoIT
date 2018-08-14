import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int fives = 0;
        int min = 2_147_483_647;
        int max = -2_147_483_647;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of a massive:");
        int n = in.nextInt();

        int[] a = new int[n];

        System.out.println("Enter the elements of a massive:");
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        for (int i = 0; i < a.length; i++)
        {
            min = min > a[i] ? a[i] : min;
            max = max < a[i] ? a[i] : max;
            if(a[i] == 5) fives++;
        }

        System.out.println("\n------------------------");
        System.out.println("Minimum value:\t\t" + min);
        System.out.println("Maximum value:\t\t" + max);
        System.out.println("Quantity of fives:\t" + fives);
        System.out.println("------------------------");
    }
}
