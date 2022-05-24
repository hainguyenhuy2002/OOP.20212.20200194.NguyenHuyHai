package hust.soict.dsai.aims.disc;

import java.time.LocalDate;

public class DigitalVideoDisc{
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private LocalDate dateAdded = LocalDate.now();
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc(String title){
        super();
        this.title = title;
        
        
        this.id = ++nbDigitalVideoDiscs;

    }
    
    public DigitalVideoDisc(String title, String category, float cost){
        this(title);
        this.category = category;
        this.cost = cost;
       
    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        this(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this(title, category, director, cost);
        this.length = length;
    }



    public String getTitle(){
        return title;
    }
     
    public String getCategory(){
        return category;
    }
    
    public String getDirector(){
        return director;
    }
    
    public int getLength(){
        return length;
    }
    
    public float getCost(){
        return cost;
    }

    public int getId(){
        return id;
    }

    public LocalDate getDayAdded() {
		return dateAdded;
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

    public void getDetail() {
		int id = this.getId();
		String title = this.getTitle();
		String category = this.getCategory();
		String director = this.getDirector();
		int length = this.getLength();
		float price = this.getCost();
		
		System.out.println(String.format("%s. DVD-%s-%s-%s-%s: %s$", id, title,category, director, length, price));
	}
}

