package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.Media;

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


	public static ArrayList<Media> sortByCost(ArrayList<Media> Media) {
		int i;
        int j;
		for(i = 0; i<Media.size()-1; i++) {
			for (j = 0 ; j < Media.size()-i-1; j++) {
				if (Media.get(j).getCost() > Media.get(j+1).getCost()) {
					
					Media.set(j, Media.get(j+1));
					Media.set(j+1, Media.get(j));
				}
			}
		}
        return Media;
    }
    
        public static ArrayList<Media> sortByTitle(ArrayList<Media> Media) {
            int i;
            int j;            
            for(i = 0; i<Media.size()-1; i++) {
                for (j = 0; j < Media.size() - i -1; j++) {
                    if ((int) Media.get(j).getTitle().charAt(0) > (int) Media.get(j+1).getTitle().charAt(0)) {
                        
                        Media.set(j, Media.get(j +1));
                        Media.set(j+1, Media.get(j));
                    }
                }
        
            }
            return Media;
        }

        
 }