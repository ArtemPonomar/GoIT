import java.util.Collections;

public class Player6 extends AdvancedPlayer{
    public Player6(int price) {
        super(price);
    }

    public void shuffle(){
        Collections.shuffle(playList);
    }
}
