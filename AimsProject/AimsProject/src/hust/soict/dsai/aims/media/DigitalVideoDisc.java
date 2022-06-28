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

	public String play(){
		String result = "Playing DVD: " + this.getTitle() + " - DVD length: "+ this.getLength();

		return result;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("CD title: ", this.getTitle()));
		result.append(String.format("CD category: ", this.getCategory()));
		result.append(String.format("CD director: ", this.getDirector()));
		result.append(String.format("CD length: ", this.getLength()));
		result.append(String.format("CD cost: ", this.getCost()));
		result.append("\nTracks on CD: \n");
        
		return result.toString();
	}



}

