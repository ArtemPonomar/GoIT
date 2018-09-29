package task1;

import java.awt.*;
import java.util.Random;

public class Randomizer {
    private static Random rand = new Random();

    public static int getRandNumberInRange(int min, int max){
        return rand.nextInt(max - min) + min;
    }

    public static Color getRandColour(){
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return new Color(r,g,b);
    }
}
