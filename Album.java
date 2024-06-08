package Oops_Project;

import java.util.*;
public class Album {
    private String name;
    private String artist;
    private ArrayList<Songs> songs;    // Arraylist of songs in the album

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Songs>();    // Initialising Songs list
    }
    public Album(){
        // Default Constructor
    }

    public Songs findSongs(String title){
        for(Songs checkedSongs: songs){
            if(checkedSongs.getTitle().equals(title))       // Return the title if found
                return checkedSongs;
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if(findSongs(title) == null){                // check if the song already exists     
            songs.add(new Songs(title, duration));   // Add the song to the album
            return true; // return true indication successsful addition
        }
        else{
            return false; // return false indication if song already exists in the album
        }
    }

    public boolean addtoPlayList(int tracknumber, LinkedList<Songs> PlayList){
        int index = tracknumber - 1;    // Convert tracknumber into index number
        if(index>0 && index <= this.songs.size()){  // Checks if track number is valid
            PlayList.add(this.songs.get(index));    // Add the song to the playlist 
            return true; // return true after successful addition
        }
        System.out.println("This album does not have the song which you are looking for");
        return false;       // return false after unsuccessful addition(invalid trackno. )
    }

    public boolean addtoPlayList(String title, LinkedList<Songs> PlayList){
        for(Songs checkedSongs: this.songs){  //Iterate through songs in album
            if(checkedSongs.getTitle().equals(title)){ 
                 // Check if song title matches specified title
                PlayList.add(checkedSongs); // Add the song to the playlist
                return true; // return true indicating successful addition
            }
        }
        return false; // return false indicating song not found in the album
    }
}
