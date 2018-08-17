import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static ArrayList getInput() {
        ArrayList a = new ArrayList();
        Scanner inn = new Scanner(System.in);

        System.out.println("Enter the elements of a massive (finish whith dot): ");
        while (inn.hasNextInt()){
            int curr = inn.nextInt();
            a.add(curr);
            System.out.print(curr + " added ");
        }

        System.out.println("exited cicle");
        return a;
    }

    public static void task1(ArrayList a) {
        int fives = 0;
        int min = 2_147_483_647;
        int max = -2_147_483_647;

        for (int i = 0; i < a.size(); i++) {
            int current = (int) a.get(i);
            if (current < min) min = current;
            if (current > max) max = current;
            if (current == 5) fives++;
        }

        System.out.println("\n------------------------");
        System.out.println("Minimum value:\t\t" + min);
        System.out.println("Maximum value:\t\t" + max);
        System.out.println("Quantity of fives:\t" + fives);
        System.out.println("------------------------");
    }

    public static void task3(ArrayList a) {
        int max = 0;
        int min = a.size();

        while (a.size() != 0) {
            int count = 0;

            int ethalon = (int) a.get(0);

            for (int i = 0; i < a.size(); i++) {
                if ((int) a.get(i) == ethalon) {
                    count++;
                    a.remove(i);    //remove similar numbers to not compare them again
                    i--;            //do not jump over next number
                }
            }

            if (max < count) max = count;
            if (min > count) min = count;
        }

        System.out.println("\n------------------------");
        System.out.println("Maximum repeats:\t\t" + max);
        System.out.println("Minimum repeats:\t\t" + min);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        ArrayList input = new ArrayList();
        input = getInput();
        task1(input);
        task3(input);
    }
}
