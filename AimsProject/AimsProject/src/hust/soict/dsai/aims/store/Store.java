package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBER_ITEM__STORE = 40; //The parameter
    private ArrayList<Media> itemsInStore = new
    ArrayList<Media>();
    
    
    public void addMedia(Media disc) {
		if (itemsInStore.size() < MAX_NUMBER_ITEM__STORE) {
			int is_duplicated =0;
			int n;
            for ( n = 0; n < itemsInStore.size(); n++) {
				if (disc == itemsInStore.get(n)) {
					is_duplicated = 1;
                    System.out.println("The disc "+ disc.getTitle() +" is already in the list of cart");
                    break;
				}
			}
            if (is_duplicated == 0){
                
                itemsInStore.add(disc);

            }
		} else {
			System.out.println("The cart is almost full");
		}
	}

    public void addMedia(Media [] dvdList){
        int k;
        for (k = 0; k< dvdList.length; k++){
            if (k + itemsInStore.size() +1 < MAX_NUMBER_ITEM__STORE){
                this.addMedia(dvdList[k]);       
                
                System.out.println("dvd " + dvdList[k].getTitle() +"have been added");
            }
            else{
                System.out.println("The cart out of capacity");
            }
        }
        

    }	
    public void removeMedia(Media disc){ //a little wrong
        int m;
        if (itemsInStore.size() ==0){
            System.out.println("The List is empty");
        }
        else{
        int removed = 0;
        for (m = 0; m< itemsInStore.size(); m++){
            if ((itemsInStore.get(m).getTitle().equals(disc.getTitle()))){
                itemsInStore.remove(m);
                System.out.println("The disc "+ disc.getTitle()+ " has been deleted");
                removed =1;
                break;
            }
        }

        if (removed == 0){
            System.out.println("The List of cart doesn't exist this disc");

        }
        
    }
    
}


public Media TitleSearch(String title){

    boolean searched = false;
    Media disc = null;
    for (int i = 0; i < itemsInStore.size(); i++) {
        if (title.contains(itemsInStore.get(i).getTitle())) {
            System.out.println(String.format("Disk with the title "+ title+ " is found"));
            itemsInStore.get(i).getInfo();
            searched = true;
            disc = itemsInStore.get(i);
            break;
        }
    }
    
    if (searched == false) {
        System.out.println("No such dics found");
    }
    return disc;
}


public void IDSearch(int id){

    if (id > MAX_NUMBER_ITEM__STORE) {
        System.out.println("Id maximum is "+ MAX_NUMBER_ITEM__STORE+" !");
    }
    
    
    //finding the disc with the same id
    if (id <= itemsInStore.size() & id != 0) {
        System.out.println(String.format("Disc found with the id "+ id+ " is found"));
        itemsInStore.get(id-1).getInfo();
    }
    else {
        System.out.println("No such disc found!");
    }
}




public void print(){
    int noOfDisc = itemsInStore.size();
    
    System.out.println("\n***********************STORE***********************");
    System.out.println("Items in the store:");
    
    for (int i = 0; i < noOfDisc; i++) {
        itemsInStore.get(i).getInfo();
    }
    System.out.println("***************************************************");
    System.out.println();
}

}
