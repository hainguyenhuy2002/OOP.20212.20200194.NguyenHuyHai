package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.lang.Object;

public class Media {
    private int id;
    private String title;
    private String category;
    private float cost; 
    private LocalDate dateAdded = LocalDate.now();
    private static int nbMedia = 0;

    public void setid(int id){
        
        this.id = ++nbMedia;
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

    
}
