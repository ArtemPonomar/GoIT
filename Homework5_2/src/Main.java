import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Song song = new Song("First song");
        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("First playlist song"));
        songs.add(new Song("Second playlist song"));
        songs.add(new Song("Third playlist song"));
        songs.add(new Song("Forth playlist song"));
        songs.add(new Song("Fifth playlist song"));

        Player1 player1 = new Player1(50);
        player1.addSong(song);

        Player2 player2 = new Player2(5);
        player2.addSong(song);

        Player3 player3 = new Player3(100);
        player3.addPlayList(songs);

        Player4 player4 = new Player4(120);
        player4.addPlayList(songs);

        Player5 player5 = new Player5(110);
        player5.addPlayList(songs);

        Player6 player6 = new Player6(112);
        player6.addPlayList(songs);

        System.out.println(player1.getPrice());
        player1.playSong();

        System.out.println(player2.getPrice());
        player2.playSong();

        System.out.println(player3.getPrice());
        player3.playSong();
        player3.playAllSongs();

        System.out.println(player4.getPrice());
        player4.playSong();
        player4.playAllSongs();

        System.out.println(player5.getPrice());
        player5.playSong();
        player5.playAllSongs();

        System.out.println(player6.getPrice());
        player6.playSong();
        player6.playAllSongs();
        player6.shuffle();
        player6.playAllSongs();





    }
}
