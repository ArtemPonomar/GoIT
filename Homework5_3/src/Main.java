import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();

        ArrayList<Flower> simpleBouquet = flowerStore.sell(4, 3, 1);
        print(simpleBouquet);

        ArrayList<Flower> composedBouquet = flowerStore.sellSequence(4, 3, 1);
        print(composedBouquet);

        ArrayList<Flower> loadedBouquet = FlowersLoader.load("./src/load_file.txt");
        print(loadedBouquet);

        FlowersSaver.save("./src/save_file.txt", loadedBouquet);
        print(loadedBouquet);
    }
    public static void print(ArrayList<Flower> bouquet){
        for (Flower flower : bouquet) {
            if (flower instanceof Rose) System.out.print("Rose ");
            if (flower instanceof Chamomile) System.out.print("Chamomile ");
            if (flower instanceof Tulip) System.out.print("Tulip ");
        }
        System.out.println();
    }
}
