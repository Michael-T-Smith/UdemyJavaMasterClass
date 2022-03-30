package LinkedList.Challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
   private String name;
    private ArrayList<Song> songs;
    private  String artist;

    public Album(String name, String artist) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.artist = artist;
    }


    public boolean addSong(String title, double duration){
        if(findSong(title) == null ){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    //iterate through list and look for song title.
    private Song findSong(String title){
        //for each loop.
        for(Song checkedSong: this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    //add song by tracknumber
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
       int index = trackNumber -1;
       if((index >=  0) && (index <= this.songs.size())) {
           playList.add(this.songs.get(index));
           return true;
       }
           System.out.println("This album does not have a track " + trackNumber);
           return false;
    };
//add song by title.
    //Overloaded method.
    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The Song " + title + " is not in this album");
        return false;
    }


}
