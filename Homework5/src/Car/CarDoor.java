package Car;

public class CarDoor {
    private boolean doorIsOpen;
    private boolean windowIsOpen;

    public CarDoor(){
        doorIsOpen = false;
        windowIsOpen = false;
    }

    public CarDoor(boolean doorIsClosed, boolean windowIsOpen){
        this.doorIsOpen = doorIsClosed;
        this.windowIsOpen = windowIsOpen;
    }

    public void openTheDoor(){
        doorIsOpen = true;
        System.out.println("Door was opened.");
    }

    public void closeTheDoor(){
        doorIsOpen = true;
        System.out.println("Door was closed.");
    }

    public void openOrCloseTheDoor(){
        if (doorIsOpen) closeTheDoor();
        else openTheDoor();
    }

    public void openTheWindow(){
        windowIsOpen = true;
        System.out.println("Window was opened.");
    }

    public void closeTheWindow(){
        windowIsOpen = true;
        System.out.println("Window was closed.");
    }

    public void openOrCloseTheWindow(){
        if (windowIsOpen) closeTheWindow();
        else openTheWindow();
    }

    public void showDoorState(){
        System.out.println("Door is " + (doorIsOpen ? "open." : "closed."));
        System.out.println("Window is " + (windowIsOpen ? "open." : "closed."));
    }
}
