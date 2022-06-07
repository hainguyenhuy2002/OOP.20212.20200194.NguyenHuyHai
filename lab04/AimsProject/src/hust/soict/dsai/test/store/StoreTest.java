package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
public class StoreTest {
	public static void main(String[] args) {
		// create a store
		Store store = new Store();
		
		//create some discs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Hai the handsome boy", "Action", "Huy Hai", 100, 20.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BlackHole", "Science Fiction", "Hai-the-proffesor", 87, 25.65f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		//add some dvds to the store
		store.addDVD(new DigitalVideoDisc[] {dvd1,dvd2,dvd3});
		
		//print all items in the store
		store.print();
		
		//remove dvd from the store
		store.removeDVD(dvd3);
		
		//print all items in the store again
		store.print();
	}
}
