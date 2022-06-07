package hust.soict.dsai.aims.track;
import hust.soict.dsai.aims.playable.Playable;

public class Track implements Playable{
    private String title;
    private int length;
    // Constructor 
    public Track(String title){
        this.title = title;
    }

    public Track(String title, int length){
        this(title);
        this.length = length;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setLength(int length){
        this.length = length;

    }

    public int getLength(){
        return length;
    }

    public void play(){
        System.out.println("Playing DVD: "+ this.getTitle());

        System.out.println("DVD length: "+ this.getLength());

    }

}
