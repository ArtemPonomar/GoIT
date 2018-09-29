import java.util.ArrayList;

public abstract class AdvancedPlayer extends Player {
    ArrayList<Song> playList = new ArrayList<>();

    public AdvancedPlayer(int price){
        super(price);
    }

    public void playAllSongs(){
        for (Song song : playList) {
            play(song);
        }
        System.out.println();
    }

    public void addPlayList(ArrayList<Song> songs){
        this.playList.addAll(songs);
    }

    @Override
    public void playSong(){
        super.play(playList.get(0));
        System.out.println();
    }
}
