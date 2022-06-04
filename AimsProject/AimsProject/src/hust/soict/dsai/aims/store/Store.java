package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	

	


    public static final int MAX_NUMBER_ITEM__STORE = 40; //The parameter
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsStore[] = new 
    DigitalVideoDisc[MAX_NUMBER_ITEM__STORE];
    
    
    public void addDVD(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBER_ITEM__STORE) {
			int is_duplicated =0;
			int n;
            for ( n = 0; n < qtyOrdered; n++) {
				if (disc == itemsStore[n]) {
					is_duplicated = 1;
                    System.out.println("The disc "+ disc.getTitle() +" is already in the list of cart");
                    break;
				}
			}
            if (is_duplicated == 0){
                
                itemsStore[qtyOrdered++] = disc;

            }
		} else {
			System.out.println("The cart is almost full");
		}
	}

    public void addDVD(DigitalVideoDisc [] dvdList){
        int k;
        for (k = 0; k< dvdList.length; k++){
            if (k + qtyOrdered +1 < MAX_NUMBER_ITEM__STORE){
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
            if ((itemsStore[m].getTitle().equals(disc.getTitle()))){
                itemsStore[m] = itemsStore[--qtyOrdered];
                itemsStore[qtyOrdered] = null;
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
        System.out.println(i+1 +"DVD - "+ itemsStore[i].getTitle() + " - "+ itemsStore[i].getCategory()+" - "+
        itemsStore[i].getDirector()+" - "+
        itemsStore[i].getLength()+": "+
        itemsStore[i].getCost()+ "$");
    }
    System.out.println("***************************************************");
    System.out.println();
}

}
