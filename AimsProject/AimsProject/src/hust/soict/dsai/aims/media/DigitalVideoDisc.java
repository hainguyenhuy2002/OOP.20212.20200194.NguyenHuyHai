package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.playable.Playable;
import java.time.LocalDate;

public class DigitalVideoDisc extends Disc implements Playable{
    // Constructor
    public DigitalVideoDisc(String title){
        super(title);
    }
    
    public DigitalVideoDisc(String title, String category, float cost){
        super(title, category, cost);
       
    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(title, category, director, length, cost);
    }

	public LocalDate getDateAdded() {
		return this.getDateAdded();
	}


    
	public boolean isMatch(String title) {
		String[] titleArray = title.split(" ");
        String trueTitle = this.getTitle();
		boolean ismatch = false;
		for (int i = 0; i<titleArray.length; i++) {
			if (trueTitle.contains(titleArray[i])) {
				ismatch = true;
			}
		}
		
		return ismatch;
	}

    //get detail information about DVD:
    public void getInfo() {
		int id = this.getid();
		String title = this.getTitle();
		String category = this.getCategory();
		String director = this.getDirector();
		int length = this.getLength();
		float price = this.getCost();
		
		System.out.println(String.format("%s. DVD-%s-%s-%s-%s: %s$", id, title,category, director, length, price));
	}

	public void play(){
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: "+ this.getLength());
	}

}

