package LinkedList.Challenge;

import java.util.LinkedList;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }
    //All classes inherited from the Object class.
    //override Object.toString() to display specific values.
    @Override
    public String toString(){
        return this.title + ". "  + this.duration + " min.";
    }
}
