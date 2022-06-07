package hust.soict.dsai.aims.media;
import java.time.LocalDate;
public class Media {
    private int id;
    private String title;
    private String category;
    private float cost; 
    private LocalDate dateAdded = LocalDate.now();
    private static int nbMedia = 0;

    //Create constructor
	public Media(String title) {
		
        this.id += nbMedia;
		this.title = title;
	}

    public Media(String title, String category, float cost) {
            this(title);
            this.category = category;
            this.cost = cost;
            this.id = ++ nbMedia;

		}

    // Setget method
    public void setid(int id){
        
        this.id = id;
    }
    
    public int getid(){
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


    //Get detail information about Media
    public void getInfo() {
		int id = this.getid();
		String title = this.getTitle();
		String category = this.getCategory();
		float price = this.getCost();
		
		System.out.println("Media - "+ id+" - "+title+" - "+category+" - "+price+"$");
	}
}
