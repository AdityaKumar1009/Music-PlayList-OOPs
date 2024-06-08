package Oops_Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
   private static ArrayList<Album> albums = new ArrayList<>();      // Collection to store Album
   
   public static void main(String[] args){
    Album album = new Album("Album 1", "Arijit Singh");
    album.addSong("Soch Na Sake", 3.9);
    album.addSong("Chahun Main Yaha Na", 3.1);
    album.addSong("Kalank", 4.2);
    album.addSong("Meri Aashiqui", 4.5);
    album.addSong("Kesariya", 3.5);
    albums.add(album);

    album = new Album("Album 2", "Ed Sheeran");
    album.addSong("Perfect", 2.8);
    album.addSong("Shape of You", 3.0);
    album.addSong("Thinking Out Loud", 3.2);
    album.addSong("South of the Border", 4.1);
    album.addSong("Photograph", 2.8); 
    albums.add(album);

    album = new Album("Album 3", "Justin Bieber");
    album.addSong("Baby", 3.0);
    album.addSong("Never Say Never", 2.9);
    album.addSong("Let Me Love YOu", 3.4);
    album.addSong("Love YOurself", 4.4);
    album.addSong("Peaches", 3.1); 
    albums.add(album);

    album = new Album("Album 4", "Armaan Malik");
    album.addSong("Vo Do Nazaraan", 4.1);
    album.addSong("Jab Takk", 3.0);
    album.addSong("Mujhko Barsaat Banalo", 3.2);
    album.addSong("Pehla Pyaar", 4.3);
    album.addSong("Sunn Mahi", 2.8); 
    albums.add(album);

    album = new Album("Album 5", "Atif Aslam");
    album.addSong("Tu Jaane Na", 2.6);
    album.addSong("Aadat", 3.0);
    album.addSong("O Saathi", 3.2);
    album.addSong("Pehli Nazar Main", 4.1);
    album.addSong("Jeene Laga Hun", 3.3); 
    albums.add(album);

    album = new Album("Album 6", "King");
    album.addSong("Tu Aake Dekh Le", 3.1);
    album.addSong("Maan Meri Jaan", 3.0);
    album.addSong("Baazi", 3.2);
    album.addSong("Good Trip", 4.1);
    album.addSong("Still The Same", 2.4); 
    albums.add(album);

    LinkedList<Songs> PlayList_1 = new LinkedList<>();             // Playlist to store songs

    //Adding songs from album to playlist
    albums.get(0).addtoPlayList("Soch Na Sake", PlayList_1);
    albums.get(0).addtoPlayList("Kalank", PlayList_1);
    albums.get(1).addtoPlayList("Shape of You", PlayList_1);
    albums.get(2).addtoPlayList("Let Me Love You", PlayList_1);
    albums.get(3).addtoPlayList("Jab Takk", PlayList_1);

    play(PlayList_1);

   }
   // Method to Handle playback of the playlist
   private static void play(LinkedList<Songs> playList){
    Scanner sc = new Scanner(System.in);
    boolean quit = false;
    boolean forward = true;
    ListIterator<Songs> listIterator = playList.listIterator();

    // Checking if playlist is empty
    if(playList.size() == 0){
        System.out.println("This Playlist has no songs");
    }
    else{     // starting playback at the first song in the playlist
        System.out.println("Now Playing" + listIterator.next().toString());
        printMenu(); 
    }
    // Handling user input for playback control
    while(!quit){
        int action = sc.nextInt();
        sc.nextLine();

        switch(action){
            case 0:
                System.out.println("Playlist complete");
                quit = true;
                break;
            
            case 1:
            // playing next song in the playlist
                if(!forward){
                    if(listIterator.hasNext()){
                        listIterator.next();
                    }
                    forward = true;
                }
                if(listIterator.hasNext()){
                    System.out.println("Now Playing" + listIterator.next().toString());
                }
                else{
                    System.out.println("No song available, reached the end of the playlist");
                    forward = false;
                }
                break;

            case 2:
            // playing the previous song in the playlist
                if(forward){
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    forward = false;
                }
                if(listIterator.hasPrevious()){
                    System.out.println("Now Playing" + listIterator.previous().toString());
                }
                else{
                    System.out.println("We are at the first song");
                    forward = true;
                }
                break;

            case 3:
            // Replaying the current song
                if(forward){
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing"+ listIterator.previous().toString());
                        forward = false;
                    }
                    else{
                        System.out.println("We are the start of the playlist");
                    }
                }
                else{
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing"+ listIterator.next().toString());
                        forward = true;
                    }
                    else{
                        System.out.println("We have reached at the end of the playlist");
                    }
                }
                break;

            case 4:
            //printing the entire playlist
                printList(playList); 
                break;

            case 5:
            //printing the playback control menu
                printMenu();   
                break;

            case 6:
            // deleting the current song from the playlist
                if(playList.size() > 0){
                    listIterator.remove();
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing"+ listIterator.next().toString());
                    }
                    else{
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing"+ listIterator.previous().toString());
                        }
                    }
                }
        }
    }
   }

   // Method to print the playback control Menu
   private static void printMenu(){
    System.out.println("Available Options\n press:");
    System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    
   }

   // Method to print the entire playlist
   private static void printList(LinkedList<Songs> Playlist){
    Iterator<Songs> iterator = Playlist.iterator();
    System.out.println("--------------------------------------------");

    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
    System.out.println("--------------------------------------------");
   }
}
