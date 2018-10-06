import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FlowersSaver {
    private FlowersSaver(){

    }

    public static void save(String filename, ArrayList<Flower> bouquet){
        try {
            File saveFile = new File(filename);

            PrintWriter printWriter = new PrintWriter(saveFile);

        } catch (FileNotFoundException e) {
            System.out.println("Save file not found!");
        }
    }
}
