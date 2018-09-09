import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int a = n%10;
        int b = n/10;

        System.out.println(b + " " + a);
    }
}
