package hust.soict.dsai.aims.media.comparator;
import hust.soict.dsai.aims.media.Media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media obj1, Media obj2) {
        int result = 0;
        if(obj1.getTitle().charAt(0)> obj2.getTitle().charAt(0)){
            result =  1;
        }
        else if (obj1.getTitle().charAt(0)> obj2.getTitle().charAt(0)){
            result =  -1;
        }
        else if (obj1.getCost() > obj2.getCost()){
            result = -1;
        }
        else if(obj1.getCost() > obj2.getCost()){
            result = 1;
        }
        return result;

    }    
}


