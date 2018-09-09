import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String flag = "y";
        String flag2 = "y";
        while(flag.equals("y")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Enter the number of the task:");
            System.out.println("1. Count from 1 to 5");
            System.out.println("2. Draw rectangle");
            System.out.println("3. Draw square");
            System.out.println("4. getMax");
            System.out.println("5. Count from 1 to 5 recursive");
            System.out.println("6. Draw rectangle recursive");

            int task = scanner.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            switch (task){
                case 1 : count();
                    break;
                case 2 : drawRectangle();
                    break;
                case 3 : drawSquare();
                    break;
                case 4 : getMaxNumber();
                    break;
                case 5 : count();
                    break;
                case 6 : drawRectangle();
                    break;
            }

            flag2 = "y";

            while (flag2.equals("y")) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Want to continue? (y/n)");
                String answer = scanner1.nextLine();
                if (answer.equals("n") || answer.equals("N")) {
                    flag = "n";
                    flag2 = "n";
                } else if (!answer.equals("y") && !answer.equals("Y")) {
                    System.out.println("Enter y for yes or n for no.");
                } else {
                    flag2 = "n";
                }
            }

        }
    }

    //Count from 1 to n
    private static void count(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the last number: ");
        countRecursive(1, scanner.nextInt());
    }

    //Count from curr to n
    private static void countRecursive(int cur, int n) {
            if (cur == n) {
                System.out.println(cur);
            } else {
                System.out.println(cur);
                cur++;
                countRecursive(cur++, n);
            }
    }

    private static void drawRectangle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length and height of rectangle: ");
        drawRectangleRecursive(scanner.nextInt(), scanner.nextInt());
    }

    private static void drawSquare(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of a square: ");
        drawRectangleRecursive(scanner.nextInt());
    }

    private static void getMaxNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the two numbers: ");
        System.out.println("Max number: " + getMax(scanner.nextFloat(), scanner.nextFloat()));
    }

    //Draw rectangle
    private static void drawRectangleRecursive(int columns, int rows){
        if(rows == 1) {
            drawLine(columns);
        } else {
            rows--;
            drawLine(columns);
            drawRectangleRecursive(columns, rows);
        }
    }

    //Draw square
    private static void drawRectangleRecursive(int rows){
        drawRectangleRecursive(rows, rows);
    }

    private static void drawLine(int a){
        if(a == 1) {
            System.out.print(" +\n");
        } else {
            System.out.print(" +");
            a--;
            drawLine(a);
        }
    }

    private static float getMax(float a, float b) {
        return (a > b ?  a : b);
    }

    private static float getMax(int a, float b) {
        return ((float) a > b ?  (float)a : b);
    }

    private static float getMax(float a, int b) {
        return ( a > (float)b ?  a : (float)b);
    }

    private static float getMax(int a, int b) {
        return ( (float)(a > b ?  a : b));
    }

}
