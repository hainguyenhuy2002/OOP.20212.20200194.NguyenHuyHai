package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DVDUtils{
    public static String compareByCost(Media disc1, 
    Media disc2 ){
        float result = disc1.getCost() - disc2.getCost();
        if(result >0){
            return "dvd"+ disc1.getTitle()+" is more expensive than "+ disc2.getTitle();
        }
        else if(result == 0){
            return "Two dvd are at the same price";
        }
        else{
            return "dvd"+ disc2.getTitle()+" is more expensive than "+ disc1.getTitle();
        }
    }

    

    public static String compareByTitle(Media disc1, Media disc2){
        float result = disc1.getTitle().compareTo(disc2.getTitle());
        if(result >0){
            return "dvd" + disc1.getTitle()+" is larger than dvd "+ disc2.getTitle() + " in alphabets orders";
        }
        else if (result == 0){
            return "both dvd are in the same order in alphabets orders";
        }
        else{
            return "dvd" + disc2.getTitle()+" is larger than dvd "+ disc1.getTitle() + " in alphabets orders";
        }
    }


	public static ObservableList<Media> sortByCost(ObservableList<Media> itemsOrdered) {
		int i;
        int j;
		for(i = 0; i<itemsOrdered.size()-1; i++) {
			for (j = 0 ; j < itemsOrdered.size()-i-1; j++) {
				if (itemsOrdered.get(j).getCost() > itemsOrdered.get(j+1).getCost()) {
					
					itemsOrdered.set(j, itemsOrdered.get(j+1));
					itemsOrdered.set(j+1, itemsOrdered.get(j));
				}
			}
		}
        return itemsOrdered;
    }
    
        public static ObservableList<Media> sortByTitle(ObservableList<Media> itemsOrdered) {
            int i;
            int j;            
            for(i = 0; i<itemsOrdered.size()-1; i++) {
                for (j = 0; j < itemsOrdered.size() - i -1; j++) {
                    if ((int) itemsOrdered.get(j).getTitle().charAt(0) > (int) itemsOrdered.get(j+1).getTitle().charAt(0)) {
                        
                        itemsOrdered.set(j, itemsOrdered.get(j +1));
                        itemsOrdered.set(j+1, itemsOrdered.get(j));
                    }
                }
        
            }
            return itemsOrdered;
        }

        
 }