import java.io.File;

public class Main {
    public static void main(String[] args) {
        String startDate = args[0];
        String endDate = args[1];
        String[] products = new String[args.length -2];

        for (int i = 2; i < args.length; i++){
            products[i-2] = args[i];
        }

        startDate = convertData(startDate);
        endDate = convertData(endDate);
    }

    private static  float getPrice(String string){
        String[] parsed = string.split(" ");
        return Float.valueOf(parsed[parsed.length]);
    }

    private static String getName(String string){
        String[] parsed = string.split(" ");
        String res = "";
        for (int i = 0; i < parsed.length - 1; i++){
            res+=parsed[i] + " ";
        }
        return res.trim();
    }

    private static float summProductsInFile(String filename, String[] products){
        File file = new File(filename);

    }

    private static String convertData(String date) {
        date = date.replace('.', '-');
        date += ".txt";
        return "./data/" + date;
    }
}
