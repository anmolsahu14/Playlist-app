import javax.swing.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album arijitAlbum = new Album(" Arijit's Album"," Arijit Singh");
        Album lataAlbum = new Album("Lata's Album","Lata Mangeshkar");

        arijitAlbum.addSongToAlbum("Kesariya",3.5);
        arijitAlbum.addSongToAlbum("Tum Kya Mile", 4.8);
        arijitAlbum.addSongToAlbum("Tu Jane Na", 5.4);

        lataAlbum.addSongToAlbum("Ji Hame Manzoor",4.5);
        lataAlbum.addSongToAlbum("Holi Khele Raghubira", 4.7);
        lataAlbum.addSongToAlbum("Jai Shree Ram",6.6);

        LinkedList<Song> myPlayList = new LinkedList<>();
        System.out.println(arijitAlbum.addToPlaylistFromAlbum("Kesariya",myPlayList));
        System.out.println(arijitAlbum.addToPlaylistFromAlbum(2,myPlayList));
        System.out.println(arijitAlbum.addToPlaylistFromAlbum(7,myPlayList));
        System.out.println(lataAlbum.addToPlaylistFromAlbum("Jai Shree Ram",myPlayList));
        System.out.println(lataAlbum.addToPlaylistFromAlbum(1,myPlayList));


        play(myPlayList);
    }

    private static void play(LinkedList<Song> myPlayList) {
        if(myPlayList.size()==0){
            System.out.println("Your Playlist Is Empty");
            return;
        }

        ListIterator<Song>itr = myPlayList.listIterator();
        System.out.println("Now playling: " + itr.next());

        Scanner sc = new Scanner(System.in);


        printMenu();

        boolean quit = false;
        while(!quit){
            System.out.println("Please Enter Your Choice");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist!!!");
                    }
                    else{
                        System.out.println("Currently Playing: " + itr.next());
                    }
                    break;
                case 3:
                    if(!itr.hasPrevious()){
                        System.out.println("You are at the start of playlist");
                    }
                    else{
                        System.out.println("Currently Playing: " + itr.previous());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6: printSongs(myPlayList);
                    break;
                case 7:
                     quit = true;
                    break;
                default:
                    System.out.println("Wrong Choice Please Enter Valid Number");
            }
        }

        return;
    }

    private static void printSongs(LinkedList<Song> myPlayList) {

        for(Song song: myPlayList){
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {

        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Repeat this song");
        System.out.println("5. Delete current song");
        System.out.println("6. Print all song");
        System.out.println("7. Quit application");

    }
}