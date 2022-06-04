package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.Arrays;
import java.util.Comparator;


public class DVDUtils{
    public static String compareByCost(DigitalVideoDisc disc1, 
    DigitalVideoDisc disc2 ){
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

    

    public static String compareByTitle(DigitalVideoDisc disc1, DigitalVideoDisc disc2){
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



    private static Comparator<DigitalVideoDisc> cost = new Comparator<DigitalVideoDisc>() {
        
        public int compare(DigitalVideoDisc dics1, DigitalVideoDisc dics2){
            return (int) (dics1.getCost()- dics2.getCost());
            
        }
    };
	




    private static Comparator<DigitalVideoDisc> title = new Comparator<DigitalVideoDisc>(){
        public int compare(DigitalVideoDisc dics1, DigitalVideoDisc dics2){
            return (int) (dics1.getTitle().compareTo(dics2.getTitle()));
        }
    };

    private static Comparator<DigitalVideoDisc> 
    length = new Comparator<DigitalVideoDisc>(){
        public int compare(DigitalVideoDisc dics1, DigitalVideoDisc dics2){
            return (int) (dics1.getLength() - dics2.getLength());
        }
    };



    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvds){
        Arrays.sort(dvds, cost);
        return dvds;
    }
    
    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvds){
        Arrays.sort(dvds, title);
        return dvds;
    }

    public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] dvds){
        Arrays.sort(dvds, length);
        return dvds;
    }



}