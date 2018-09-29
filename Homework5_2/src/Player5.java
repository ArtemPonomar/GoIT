public class Player5 extends AdvancedPlayer{
    public Player5(int price) {
        super(price);
    }

    @Override
    public void playAllSongs(){
        for (int i = playList.size() - 1; i > 0; i--) {
            play(playList.get(i));
        }
        System.out.println();
    }
}
