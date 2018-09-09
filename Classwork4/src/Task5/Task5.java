package Task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
    private static ArrayList<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int currentNumber = 1;
        while (variants(currentNumber) != n){
            currentNumber++;
        }

        System.out.println(String.valueOf(currentNumber));
    }

    private static int variants(int currentNumber) {
        boolean currentNumberIsPrime = true;

        int primeNumbersIndex = -1;
        int maxPrimal = (int) Math.sqrt(currentNumber);
        for (int prime : primeNumbers) {
            primeNumbersIndex++;
            if (prime > maxPrimal) {
                break;
            }
            if (currentNumber % prime == 0) {
                currentNumberIsPrime = false;
                break;
            }
        }
        if(currentNumber == 1){
            return 1;
        }
        if (currentNumberIsPrime) {
            primeNumbers.add(currentNumber);
            return 1;
        }

        int resultRaw = 1;
        while (currentNumber != 1) {
            int currentPrime = primeNumbers.get(primeNumbersIndex);
            int primeRepeating = 0;
            while (currentNumber % currentPrime == 0){
                primeRepeating++;
                currentNumber /= currentPrime;
            }
            resultRaw *= (primeRepeating + 1);
            primeNumbersIndex ++;
        }
        return ((resultRaw + 1) / 2);
    }
}
