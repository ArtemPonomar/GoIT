package Boat;

public class Boat {
    private int naxCount = 5;
    private int count = 0;

    public void addPassenger(){
        if(count < 5) {
            count++;
            System.out.println("Passenger added. Passenger count is " + count + ".");
        } else {
            System.out.println("Boat is full");
        }
    }

    public void unloadPassenger(){
        if(count > 0) {
            count--;
            System.out.println("Passenger unloaded. Passenger count is " + count + ".");
        } else {
            System.out.println("Boat is empty.");
        }
    }

    public void unloadAll(){
        count = 0;
        System.out.println("Boat is empty.");

    }
}
