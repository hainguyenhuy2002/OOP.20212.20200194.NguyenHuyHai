package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	

	


    public static final int MAX_NUMBER_OF_ITEM_IN_STORE = 40; //The parameter
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsInStore[] = new 
    DigitalVideoDisc[MAX_NUMBER_OF_ITEM_IN_STORE];
    public void addDVD(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBER_OF_ITEM_IN_STORE) {
			int is_duplicated =0;
			int n;
            for ( n = 0; n < qtyOrdered; n++) {
				if (disc == itemsInStore[n]) {
					is_duplicated = 1;
                    System.out.println("The disc "+ disc.getTitle() +" is already in the list of cart");
                    break;
				}
			}
            if (is_duplicated == 0){
                
            itemsInStore[qtyOrdered++] = disc;

            }
		} else {
			System.out.println("The cart is almost full");
		}
	}

    public void addDVD(DigitalVideoDisc [] dvdList){
        int k;
        for (k = 0; k< dvdList.length; k++){
            if (k + qtyOrdered +1 < MAX_NUMBER_OF_ITEM_IN_STORE){
                this.addDVD(dvdList[k]);       
                
                System.out.println("dvd " + dvdList[k].getTitle() +"have been added");
            }
            else{
                System.out.println("The cart out of capacity");
            }
        }
        

    }









	

	
    public void removeDVD(DigitalVideoDisc disc){ //a little wrong
        int m;
        if (qtyOrdered ==0){
            System.out.println("The List is empty");
        }
        else{
        int removed = 0;
        for (m = 0; m< qtyOrdered; m++){
            if ((itemsInStore[m].getTitle().equals(disc.getTitle()))){
                itemsInStore[m] = itemsInStore[--qtyOrdered];
                itemsInStore[qtyOrdered] = null;
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

public void print(){
    int noOfDisc = qtyOrdered;
    
    System.out.println("\n***********************STORE***********************");
    System.out.println("Items in the store:");
    
    for (int i = 0; i < noOfDisc; i++) {
        System.out.println(i+1 +"DVD - "+ itemsInStore[i].getTitle() + " - "+ itemsInStore[i].getCategory()+" - "+
        itemsInStore[i].getDirector()+" - "+
        itemsInStore[i].getLength()+": "+
        itemsInStore[i].getCost()+ "$");
    }
    System.out.println("***************************************************");
    System.out.println();
}

}
