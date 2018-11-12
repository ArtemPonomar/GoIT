package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть к-ть людей і ємкість бібліотеки:");

        Library library = new Library(scanner.nextInt(), scanner.nextInt());
        library.open();
    }
}
