package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
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
    public String getInfo() {
		int id = this.getId();
		String title = this.getTitle();
		String category = this.getCategory();
		String director = this.getDirector();
		int length = this.getLength();
		float price = this.getCost();
		
		return String.format("DVD- ID: %s.-Title: %s-Director: %s-category: %s-Length: %s: Cost: %s$", id, title,category, director, length, price);
	}

	public String play() throws PlayerException{
		if(this.getLength() > 0){
		String result = this.getInfo();

		return result;
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
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

