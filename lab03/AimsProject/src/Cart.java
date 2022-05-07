public class Cart {
    public static final int MAX_NUMBERS_OREDERD = 4; //The parameter
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
    public float totalCost(){
        float total_cost = 0;
        int j;
        for (j = 0; j< qtyOrdered; j++){
            total_cost += itemsOrdered[j].getCost();
        }
        return total_cost;

    }

    
    }

