package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;



public class Cart {
    public static final int MAX_NUMBERS_OREDERD = 20; //The parameter
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new 
    DigitalVideoDisc[MAX_NUMBERS_OREDERD];
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_OREDERD) {
			int is_duplicated =0;
			int n;
            for ( n = 0; n < qtyOrdered; n++) {
				if (disc == itemsOrdered[n]) {
					is_duplicated = 1;
                    System.out.println("The disc "+ disc.getTitle() +" is already in the list of cart");
                    break;
				}
			}
            if (is_duplicated == 0){
                
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println("The disc "+ disc.getTitle() + " has been added");
            }
		} else {
			System.out.println("The cart is almost full");
		}
	}

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        int k;
        for (k = 0; k< dvdList.length; k++){
            if (k + qtyOrdered +1 < MAX_NUMBERS_OREDERD){
                this.addDigitalVideoDisc(dvdList[k]);       
                
                System.out.println("dvd " + dvdList[k].getTitle() +" in dvdList have been added");
            }
            else{
                System.out.println("The cart out of capacity");
            }
        }
        

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered + 2 < MAX_NUMBERS_OREDERD){
            this.addDigitalVideoDisc(dvd1);
            this.addDigitalVideoDisc(dvd2);

        }
        else if (qtyOrdered + 1< MAX_NUMBERS_OREDERD){
            this.addDigitalVideoDisc(dvd1);
            if (qtyOrdered +1 < MAX_NUMBERS_OREDERD){
                this.addDigitalVideoDisc(dvd2);
            }
            
        
        }
        else{
            System.out.println("The cart out of capacity");
        }
    }
    
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){ //a little wrong
            int m;
            if (qtyOrdered ==0){
                System.out.println("The List is empty");
            }
            else{
            int removed = 0;
            for (m = 0; m< qtyOrdered; m++){
                if ((itemsOrdered[m].getTitle().equals(disc.getTitle()))){
                    itemsOrdered[m] = itemsOrdered[--qtyOrdered];
					itemsOrdered[qtyOrdered] = null;
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
        this.itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
    }

    public void TitleSort(){
        this.itemsOrdered = DVDUtils.sortByTitle(itemsOrdered);
    }


    public void LengthSort(){
        this.itemsOrdered = DVDUtils.sortByLength(itemsOrdered);
    }

    public void IdSearch(int id) {
        //boolean isId = false;
        if (id > MAX_NUMBERS_OREDERD) {
			System.out.println("Id maximum is "+ MAX_NUMBERS_OREDERD+" !");
		}
		
		
		//finding the disc with the same id
		if (id <= qtyOrdered & id != 0) {
			System.out.println(String.format("Disc found with the id: %s!", id));
			System.out.println("DVD - "+ itemsOrdered[id-1].getTitle() + " - "+ itemsOrdered[id-1].getCategory()+" - "+
				itemsOrdered[id-1].getDirector()+" - "+
				itemsOrdered[id-1].getLength()+": "+
				itemsOrdered[id-1].getCost()+ "$");
		}
		else {
			System.out.println("No such disc found with that id!");
		}
	}
            
        
    

    public DigitalVideoDisc TitileSearch(String title){

		boolean searched = false;
		DigitalVideoDisc Title = null;
		
		for (int i = 0; i < qtyOrdered; i++) {
			if (title.contains(itemsOrdered[i].getTitle())) {
				System.out.println(String.format("Disk with the title "+ title+ " is found"));
				System.out.println("DVD - "+ itemsOrdered[i].getTitle() + " - "+ itemsOrdered[i].getCategory()+" - "+
				itemsOrdered[i].getDirector()+" - "+
				itemsOrdered[i].getLength()+": "+
				itemsOrdered[i].getCost()+ "$");
				searched = true;
				Title = itemsOrdered[i];
				break;
			}
		}
		
		if (searched == false) {
			System.out.println(String.format("No such dics found with the title: %s!", title));
		}
		return Title;

    }



    public void AllItems(){
        
        
        DigitalVideoDisc[] ListOfCart = new DigitalVideoDisc[qtyOrdered];
        int i = 0;
        for(i = 0; i < qtyOrdered; i++){
            ListOfCart[i] = itemsOrdered[i];
        }
        ListOfCart = DVDUtils.sortByLength(ListOfCart);
        ListOfCart = DVDUtils.sortByCost(ListOfCart);
        ListOfCart = DVDUtils.sortByTitle(ListOfCart);
        System.out.println("***********************CART************************");
        System.out.println("Ordered Items:");
        for( i = 0; i < qtyOrdered; i++){
            System.out.println(i+1 +"DVD - "+ itemsOrdered[i].getTitle() + " - "+ itemsOrdered[i].getCategory()+" - "+
            itemsOrdered[i].getDirector()+" - "+
            itemsOrdered[i].getLength()+": "+
            itemsOrdered[i].getCost()+ "$");

    
        }
        System.out.println("Total cost: "+ this.totalCost());
        System.out.println("***************************************************");
    }
    
	

    public float totalCost(){
        float total_cost = 0;
        int j;
        for (j = 0; j< qtyOrdered; j++){
            total_cost += itemsOrdered[j].getCost();
        }
        return total_cost;

    }

    
    }

