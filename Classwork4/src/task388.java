import java.util.Scanner;

public class task388 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = 0;

        while(n!=1) {
            if(n % 2 == 1) {
                count++;
                n++;
            } else {
                n /= 2;
                count++;
            }
        }

        System.out.println(count);
    }
}

