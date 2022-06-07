package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.track.Track;
import hust.soict.dsai.aims.playable.Playable;
import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
    private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
    //Constructor
	public CompactDisc(String title){
        super(title);
    }

    public CompactDisc(String title, String artist){
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost){
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist){
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, float cost){
        super(title, category, director, cost);
    }

    public CompactDisc(String title, String category,String director, float cost, String artist){
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost){
        super(title, category, director, length, cost);
    }

    public CompactDisc(String title, String category,String director, int length, float cost, String artist){
        super(title, category, director,length, cost);
        this.artist = artist;
    }
	
	public void addTrack(Track Track) {
		if (this.tracks.contains(Track)){
			System.out.print(String.format("The track is already inside !"));
		}
		else {
			tracks.add(Track);
			System.out.println(String.format("Successfully add a Track: ", Track.getTitle()));
		}
	}
	
	public void removeTrack(Track Track) {
		if (this.tracks.contains(Track)) {
			tracks.remove(Track);
			System.out.println(String.format("Successfull remove a track", Track.getTitle()));
		}
		else {
			System.out.println(String.format("Track no found"));
		}
	}
	
	
	//Method play
    public void play() {
		for(Track track : this.tracks) {
			track.play();
		}
	}
	

}
