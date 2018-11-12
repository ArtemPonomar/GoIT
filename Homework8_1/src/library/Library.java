package library;

import java.util.concurrent.Semaphore;

public class Library {
    private final int peopleCount;
    private final Semaphore freeSeats;
    private final Semaphore door;
    public boolean canEnter;

    public Library(int peopleCount, int maxCount) {
        this.peopleCount = peopleCount;
        this.freeSeats = new Semaphore(maxCount);
        this.door = new Semaphore(1);
    }

    public Semaphore getFreeSeats(){
        return freeSeats;
    }

    public Semaphore getDoor(){
        return door;
    }

    public void open(){
        for(int i = 0; i < peopleCount; i++){
            new Human(this).start();
        }
    }
}
