package library;

import java.util.Random;

public class Human extends Thread {
    private Library library;

    public Human(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            System.out.println("Я прийшов до бібліотеки.");

            library.getFreeSeats().acquire();

            System.out.println("Підійшов до двері з вулиці.");
            library.getDoor().acquire();
            System.out.println("Проходжу крізь двірі всередину.");
            Thread.sleep(500);
            System.out.println("Пройшов крізь двірі всередину.");
            library.getDoor().release();

            System.out.println("Я зайшов у бібліотеку");

            int readingTime = random.nextInt(4000) + 1000;
            System.out.println("Я читаю книгу.");
            Thread.sleep(readingTime);

            System.out.println("Підійшов до двері з середини.");
            library.getDoor().acquire();
            System.out.println("Проходжу крізь двері назовні.");
            Thread.sleep(500);
            System.out.println("Пройшов крізь двері назовні.");
            library.getDoor().release();

            library.getFreeSeats().release();
            System.out.println("Я вийшов з бібліотеки");
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
