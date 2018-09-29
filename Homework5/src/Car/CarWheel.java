package Car;

public class CarWheel {
    private double durability;

    public CarWheel(){
        durability = 1;
    }

    public CarWheel(double durability){
        this.durability = durability;
    }

    public void changeTire(){
        durability = 1;
    }

    public void wereOutTire(double percents){
        durability /= 100*(100 - percents);
        if(durability < 0) durability = 0;
    }

    public double getDurability(){
        return durability;
    }

    public void showState(){
        System.out.println("Tires have " + durability + " durability left.");
    }
}
