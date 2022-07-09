package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;
import hust.soict.dsai.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.comparator.MediaComparatorByTitleCost;
public class Media implements Comparable<Media>{
    private int id;
    private String title;
    private String category;
    private float cost; 
    private LocalDate dateAdded = LocalDate.now();
    private static int nbMedia = 0;

// define constant Media comparators
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();




    //Create constructor
	public Media(String title) {
		
        this.id += nbMedia;
		this.title = title;
	}

    public Media(String title, String category, float cost) {
            this.id = ++ nbMedia;

            this.title = title;
            this.category = category;
            this.cost = cost;

		}

    // Setget method
    public void setid(int id){
        
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public float getCost(){
        return cost;
    }

    public void setDayAdded(LocalDate dateAdded){
        this.dateAdded = dateAdded;
    }

    public LocalDate getDayAdded(){
        return dateAdded;
    }

    public void setnbMedia(int nbMedia){
        Media.nbMedia = nbMedia;
    }
    
    public static int getnbMedia(){
        return nbMedia;
    }

    public boolean equals(Object o){
        if(o instanceof Media){
            return this.id == ((Media)o).id;
        }
        else{
            return false;
        }
    }

    public int compareTo(Media obj){
        int result = 0;
		if (this.getTitle().charAt(0) < obj.getTitle().charAt(0)) {
			result = -1;
		}
		else if (this.getTitle().charAt(0) > obj.getTitle().charAt(0)) {
			result = 1;
		}
		else {
			if (this.getCategory().charAt(0) < obj.getCategory().charAt(0)) {
				result = -1;
			}
			else if (this.getCategory().charAt(0) > obj.getCategory().charAt(0)) {
				result = 1;
			}
		}
		return result;
    }



    //Get detail information about Media
    public String getInfo() {
		int id = this.getId();
		String title = this.getTitle();
		String category = this.getCategory();
		float price = this.getCost();
		
		return "Media - "+ id+" - "+title+" - "+category+" - "+price+"$";
	}
}
