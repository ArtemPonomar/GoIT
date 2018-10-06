import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlowersLoader {
    private FlowersLoader(){

    }

    public static ArrayList<Flower> load(String filename) {
        try {
            ArrayList<Flower> bouquet = new ArrayList<>();

            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String curr = scanner.nextLine();
                if(curr.equals("rose")) bouquet.add(new Rose());
                if(curr.equals("chamomile")) bouquet.add(new Chamomile());
                if(curr.equals("tulip")) bouquet.add(new Tulip());
            }

            return bouquet;
        } catch (FileNotFoundException e){
            System.out.println("Load file not found!");
            return null;
        }
    }
}
