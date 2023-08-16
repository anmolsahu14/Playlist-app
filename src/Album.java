import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Album {

    private String name;

    private String artist;

    private List<Song>songs;

    public Album() {
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    boolean findSong(String name){
        for(Song song : songs){
            if(song.getTitle().equals(name)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            //add
            Song song = new Song(title,duration);
            this.songs.add(song);
            return "Song has been added to the Album";
        }
        return "Song already exists";
    }

    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playList){

        for(Song song:this.songs){
            if(song.getTitle().equals(title)){
                playList.add(song);
                return " Song has been added to your playlist";
            }
        }
        return " Song doesnot exist in album";
    }

    public String addToPlaylistFromAlbum(int songNo, LinkedList<Song>playList){
        int index = songNo - 1;
        if(index >= 0 && index <= songs.size()){
            playList.add(songs.get(index));
            return " Song has been added Successfully!!!";
        }

        return "Incorrect Song Number!!!";
    }
}
