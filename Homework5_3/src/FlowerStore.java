import java.util.ArrayList;

public class FlowerStore {
    private static int moneyInBank = 0;

    public static ArrayList<Flower> sell(int rose, int cham, int tulip){
        ArrayList<Flower> bouquet = new ArrayList<>();

        for (int i = 0; i < rose; i++) {
            bouquet.add(new Rose());
        }
        for (int i = 0; i < cham; i++) {
            bouquet.add(new Chamomile());
        }
        for (int i = 0; i < tulip; i++) {
            bouquet.add(new Tulip());
        }

        for (Flower f : bouquet) {
            moneyInBank += f.getPrice();
        }

        return bouquet;
    }

    public static ArrayList<Flower> sellSequence(int rose, int cham, int tulip){
        ArrayList<Flower> bouquet = new ArrayList<>();

        while (rose + cham + tulip > 0){
            if(rose > 0){
                bouquet.add(new Rose());
                rose--;
            }
            if(cham > 0){
                bouquet.add(new Chamomile());
                cham--;
            }
            if(tulip > 0){
                bouquet.add(new Tulip());
                tulip--;
            }
        }

        for (Flower f : bouquet) {
            moneyInBank += f.getPrice();
        }

        return bouquet;
    }


}
