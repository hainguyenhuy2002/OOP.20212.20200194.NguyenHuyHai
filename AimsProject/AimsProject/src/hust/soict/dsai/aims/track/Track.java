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


    public boolean equals(Object o){
        if(o instanceof Track){
            return (this.title == ((Track) o).title & this.length ==((Track) o).length);
        }
        else{
            return false;
        }
    }


    public void play(){
        if(this.getLength() <= 0){
            System.out.println("The track cannot be played");
        }
        else{
        System.out.println("Playing DVD: "+ this.getTitle());

        System.out.println("DVD length: "+ this.getLength());
        }

    }

}
