package Car;

import java.util.ArrayList;

public class Car {
    private final String dateOfCreation;
    private String engineType;
    private double maxSpeed;
    private int secondsToReach100kmh;
    private int maxCapacity;
    private int currentCapacity;
    private double currentSpeed;
    private ArrayList<CarWheel> wheels;
    private ArrayList<CarDoor> doors;

    public Car(String dateOfCreation){
        this.dateOfCreation = dateOfCreation;
    }

    public Car(String dateOfCreation, String engineType, double maxSpeed, int secondsToReach100kmh, int maxCapacity, int currentCapacity, double currentSpeed){
        this.dateOfCreation = dateOfCreation;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.secondsToReach100kmh = secondsToReach100kmh;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.currentSpeed = currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public void addPassenger(){
        if(currentCapacity < maxCapacity) currentCapacity++;
    }

    public void removePassenger(){
        if(currentCapacity > 0) currentCapacity--;
    }

    public void removeAllPassengers(){
        currentCapacity = 0;
    }

    public CarDoor getDoor(int i){
        return doors.get(i);
    }

    public CarWheel getWheel(int i){
        return wheels.get(i);
    }

    public void removeAllWheels(){
        wheels.clear();
    }

    public void addWheels(ArrayList<CarWheel> addedWheels){
        wheels.addAll(addedWheels);
    }

    public double calculateMaxSpeed(){
        double worstWheel = 1;
        if(currentCapacity == 0) return 0;
        for (CarWheel wheel: wheels) {
            if (wheel.getDurability() < worstWheel) worstWheel = wheel.getDurability();
        }
        return maxSpeed*worstWheel;
    }

    public void showStatus(){
        System.out.println("Car was created in: " + dateOfCreation);
        System.out.println("Engine type: " + engineType);
        System.out.println("Theoretical max speed: " + maxSpeed);
        System.out.println("Real max speed: " + calculateMaxSpeed());
        System.out.println("Seconds to reach 100 km/h: " + secondsToReach100kmh);
        System.out.println("Max capacity: " + maxCapacity);
        System.out.println("Current capacity: " + currentCapacity);
        System.out.println("Current speed: " + currentSpeed);
    }
}
