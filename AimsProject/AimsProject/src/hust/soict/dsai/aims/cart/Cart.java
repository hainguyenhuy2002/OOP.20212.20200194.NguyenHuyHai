package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Random;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.text.DecimalFormat;




public class Cart {
    public static final int MAX_NUMBERS_OREDERD = 20; //The parameter
    //private int qtyOrdered = 0;
    // private DigitalVideoDisc itemsOrdered[] = new 
    // DigitalVideoDisc[MAX_NUMBERS_OREDERD];
    private ObservableList<Media> itemsOrdered = 
			FXCollections.observableArrayList();


    // public void addDigitalVideoDisc(Media disc) {
	// 	if (qtyOrdered < MAX_NUMBERS_OREDERD) {
	// 		int is_duplicated =0;
	// 		int n;
    //         for ( n = 0; n < qtyOrdered; n++) {
	// 			if (disc == itemsOrdered[n]) {
	// 				is_duplicated = 1;
    //                 System.out.println("The disc "+ disc.getTitle() +" is already in the list of cart");
    //                 break;
	// 			}
	// 		}
    //         if (is_duplicated == 0){
                
	// 		itemsOrdered[qtyOrdered++] = disc;
	// 		System.out.println("The disc "+ disc.getTitle() + " has been added");
    //         }
	// 	} else {
	// 		System.out.println("The cart is almost full");
	// 	}
	// }
    


    public void addMedia(Media disc) {
		if (itemsOrdered.size() < MAX_NUMBERS_OREDERD) {
			int is_duplicated =0;
			int n;
            for ( n = 0; n < itemsOrdered.size(); n++) {
				if (disc == itemsOrdered.get(n)) {
					is_duplicated = 1;
                    System.out.println("The disc "+ disc.getTitle() +" is already in the list of cart");
                    break;
				}
			}
            if (is_duplicated == 0){
                
			itemsOrdered.add(disc);
			System.out.println("The disc "+ disc.getTitle() + " has been added");
            }
		} else {
			System.out.println("The cart is almost full");
		}
	}




    // public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
    //     int k;
    //     for (k = 0; k< dvdList.length; k++){
    //         if (k + qtyOrdered +1 < MAX_NUMBERS_OREDERD){
    //             this.addDigitalVideoDisc(dvdList[k]);       
                
    //             System.out.println("dvd " + dvdList[k].getTitle() +" in dvdList have been added");
    //         }
    //         else{
    //             System.out.println("The cart out of capacity");
    //         }
    //     }
        

    // }

    public void addMedia(Media [] dvdList){
        int k;
        for (k = 0; k< dvdList.length; k++){
            if (k + itemsOrdered.size() +1 < MAX_NUMBERS_OREDERD){
                this.addMedia(dvdList[k]);       
                
                System.out.println("dvd " + dvdList[k].getTitle() +" in dvdList have been added");
            }
            else{
                System.out.println("The cart out of capacity");
            }
        }
        

    }







    
    // public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
    //     if (qtyOrdered + 2 < MAX_NUMBERS_OREDERD){
    //         this.addDigitalVideoDisc(dvd1);
    //         this.addDigitalVideoDisc(dvd2);

    //     }
    //     else if (qtyOrdered + 1< MAX_NUMBERS_OREDERD){
    //         this.addDigitalVideoDisc(dvd1);
    //         if (qtyOrdered +1 < MAX_NUMBERS_OREDERD){
    //             this.addDigitalVideoDisc(dvd2);
    //         }
            
        
    //     }
    //     else{
    //         System.out.println("The cart out of capacity");
    //     }
    // }


    public void addMedia(Media dvd1, Media dvd2){
        if (itemsOrdered.size() + 2 < MAX_NUMBERS_OREDERD){
            this.addMedia(dvd1);
            this.addMedia(dvd2);

        }
        else if (itemsOrdered.size() + 1< MAX_NUMBERS_OREDERD){
            this.addMedia(dvd1);
            if (itemsOrdered.size() +1 < MAX_NUMBERS_OREDERD){
                this.addMedia(dvd2);
            }
            
        
        }
        else{
            System.out.println("The cart out of capacity");
        }
    }

    
    
    // public void removeDigitalVideoDisc(DigitalVideoDisc disc){ //a little wrong
    //         int m;
    //         if (qtyOrdered ==0){
    //             System.out.println("The List is empty");
    //         }
    //         else{
    //         int removed = 0;
    //         for (m = 0; m< qtyOrdered; m++){
    //             if ((itemsOrdered[m].getTitle().equals(disc.getTitle()))){
    //                 itemsOrdered[m] = itemsOrdered[--qtyOrdered];
	// 				itemsOrdered[qtyOrdered] = null;
    //                 System.out.println("The disc "+ disc.getCategory()+ " has been deleted");
    //                 removed =1;
    //                 break;
    //             }
    //         }

    //         if (removed == 0){
    //             System.out.println("The List of cart doesn't exist this disc");

    //         }
            
    //     }
        
    // }



    public void removeMedia(Media disc){ //a little wrong
        int m;
        if (itemsOrdered.size() ==0){
            System.out.println("The List is empty");
        }
        else{
        int removed = 0;
        for (m = 0; m< itemsOrdered.size(); m++){
            if ((itemsOrdered.get(m).getTitle().equals(disc.getTitle()))){
                itemsOrdered.remove(m);
                System.out.println("The disc "+ disc.getCategory()+ " has been deleted");
                removed =1;
                break;
            }
        }

        if (removed == 0){
            System.out.println("The List of cart doesn't exist this disc");

        }
        
    }
    
}




 

    public void CostSort(){
        ObservableList<Media> CostSorts = DVDUtils.sortByCost(itemsOrdered);
        System.out.println("items list sort by cost: ");
		for (int i = 0; i < CostSorts.size(); i ++) {
			CostSorts.get(i).getInfo();
		}
    }

    public void TitleSort(){
        ObservableList<Media> TitleSort = DVDUtils.sortByTitle(itemsOrdered);
        System.out.println("items list sort by title: ");
		for (int i = 0; i < TitleSort.size(); i ++) {
			TitleSort.get(i).getInfo();
		}
    }



    public void IdSearch(int id) {
        //boolean isId = false;
        if (id > MAX_NUMBERS_OREDERD) {
			System.out.println("Id maximum is "+ MAX_NUMBERS_OREDERD+" !");
		}
		
		
		//finding the disc with the same id
		if (id <= itemsOrdered.size() & id != 0) {
			System.out.println(String.format("Disc found with the id "+ id+ " is found"));
			itemsOrdered.get(id-1).getInfo();
		}
		else {
			System.out.println("No such disc found!");
		}
	}
            
        
    

    public Media TitleSearch(String title){

		boolean searched = false;
		Media disc = null;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (title.contains(itemsOrdered.get(i).getTitle())) {
				System.out.println(String.format("Disk with the title "+ title+ " is found"));
				itemsOrdered.get(i).getInfo();
				searched = true;
				disc = itemsOrdered.get(i);
                break;
			}
		}
		
		if (searched == false) {
			System.out.println("No such dics found");
		}
        return disc;
    }


    // Get the size of the list
    public int getsize(){
        return itemsOrdered.size();
    }

    public void print(){
        
        
        itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
        itemsOrdered = DVDUtils.sortByTitle(itemsOrdered);
        System.out.println("***********************CART************************");
        System.out.println("Ordered Items:");
        int i;
        for( i = 0; i < itemsOrdered.size(); i++){
            itemsOrdered.get(i).getInfo();

    
        }
        System.out.println("Total cost: "+ this.totalCost());
        System.out.println("***************************************************");
    }
    
	
    //Calculate total cost
    public String totalCost(){

        float total_cost = 0;
        int j;
        for (j = 0; j< itemsOrdered.size(); j++){
            total_cost += itemsOrdered.get(j).getCost(); //Using loop to get the total cost.
        }
        return String.format("%.2f", total_cost);

    }
    //Get lucky items
    public Media getALuckyItem(){
        // Random rn = new Random(); //Create random function
		// int intRand = rn.nextInt(itemsOrdered.size());
        // Media luckyItem =  itemsOrdered.get(intRand); 
              
        // if ( itemsOrdered.size()<5){
        //     try{
        //         throw new Exception();
        //     }catch (Exception e){
        //         System.out.println("Not enough media"); //raise exception if not satisfied condition
        //     }

        // }
        // else{
        //     luckyItem.setCost(0);
        // }
        // return luckyItem; // return luckyItem; 
        if (itemsOrdered.size()>5){
            Random random = new Random();
            int intRand = random.nextInt(itemsOrdered.size());
            Media LuckyItem = itemsOrdered.get(intRand);
            LuckyItem.setCost(0);
            System.out.println(String.format("Successfully get lucky items: "+ LuckyItem.getTitle()));
            return LuckyItem;

        }
        System.out.println("Not enough Media to get lucky items");
        return null; 
        



    }

    public void emptyCart() {
		this.itemsOrdered = FXCollections.observableArrayList();; 
	} 

    public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}


}

