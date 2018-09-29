public class Player4 extends AdvancedPlayer{
    public Player4(int price) {
        super(price);
    }

    @Override
    public void playSong(){
        play(playList.get(playList.size() - 1));
        System.out.println();
    }
}
