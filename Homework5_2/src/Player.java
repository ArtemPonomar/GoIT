
public abstract class Player {
    protected final int price;
    Song song;

    public Player(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void playSong(){
        play(song);
        System.out.println();
    }

    protected void addSong(Song song){
        this.song = song;
    }

    protected void play(Song song){
        System.out.println("Playing: " + song.getName());
    }
}
