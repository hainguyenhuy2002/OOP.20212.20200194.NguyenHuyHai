package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
public class StoreTest {
	public static void main(String[] args) {
		// create a store
		Store store = new Store();
		
		//create some discs
		Media dvd1 = new Media("Hai the handsome boy", "Action",  20.95f);
		Media dvd2 = new Media("BlackHole", "Science Fiction",  25.65f);
		Media dvd3 = new Media("Aladin", "Animation", 18.99f);
		
		//add some dvds to the store
		store.addMedia(new Media[] {dvd1,dvd2,dvd3});
		
		//print all items in the store
		store.print();
		
		//remove dvd from the store
		store.removeMedia(dvd3);
		
		//print all items in the store again
		store.print();
	}
}
