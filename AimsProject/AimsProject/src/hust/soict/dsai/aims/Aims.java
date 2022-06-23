package hust.soict.dsai.aims;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.memory.MemoryDaemon;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;;

public class Aims {
	private static Scanner scanner = new Scanner(System.in);
	private static Cart cart = new Cart();
	private static Store store = new Store();


	public static void main(String[] args) {
		
		Thread thread = new Thread(new MemoryDaemon());
		thread.setDaemon(true);
		thread.start();
		
		Store store = new Store();
		
		for(int i = 1; i < 5; i++) {
			DigitalVideoDisc media = new DigitalVideoDisc("The Lion King " + i, "Animation", "Roger Allers", 87, 19.95f);
			store.addMedia(media);
		}

		DigitalVideoDisc media2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media2);
		
		DigitalVideoDisc media3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(media3);
		
		DigitalVideoDisc media4 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media4);

		DigitalVideoDisc media5 = new DigitalVideoDisc("The King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media5);
		
		store.addMedia(new DigitalVideoDisc("SpyXFamily", "Action", "Anya", 85, 19.02f));
		
		new StoreManagerScreen(store);	
	}



	public static void showMenu() {
		System.out.println("AIMS:  ");
		System.out.println("-------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		System.out.println();
		
		int Menuchoose = scanner.nextInt();
		
		if (Menuchoose == 1) {
			storeMenu();
		}
		else if (Menuchoose == 2) {
			updateStore();
		}
		else if (Menuchoose == 3) {
			cartMenu();
		}
		else if (Menuchoose == 0){
			System.exit(0);
		}
		else {
			System.out.println("You must enter a valid number");
			showMenu();
		}
	}
	
	public static void storeMenu() {
		System.out.println("Options:  ");
		System.out.println("-------------------------");
		System.out.println("1. See a Media's details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		System.out.println();
		
		int Menustore = scanner.nextInt();
		
		if (Menustore == 1) {
			System.out.println("Enter the title of media that you want to see ");
			String title = scanner.next();
			System.out.println();
			if (store.TitleSearch(title) != null) {
				System.out.println("\n\nDo you want to add this media to your cart. Please enter Yes or No?");
				String y = scanner.next().toLowerCase();
				if (y.equals("Yes")) {
					cart.addMedia(store.TitleSearch(title));
					storeMenu();
				}
				else {
					System.out.println("The media is not added");
					storeMenu();
				}
			}
			else {
				storeMenu();
			}
		}
		else if (Menustore == 2) {
			System.out.println("Enter the title of the media that you want to add: ");
			String title = scanner.next();
			System.out.println();
			
			cart.addMedia(store.TitleSearch(title));
			storeMenu();
		}
		else if (Menustore == 3) {
			cartMenu();
		}


		else if (Menustore == 0){
			showMenu();
		}
		else {
			System.out.println("You must enter a valid number");
			storeMenu();
		}
	}
	
	public static void updateStore() {
		System.out.println("Options:  ");
		System.out.println("-------------------------");
		System.out.println("1. Add Media to the cart");
		System.out.println("2. Remove a Media from the cart");
		System.out.println("0. Go Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int updateStore = scanner.nextInt();
		
		if (updateStore == 1) {
			System.out.println("Follow these step to add Media ");
			System.out.print("Enter the title of the disc you want to add: ");
			String title = scanner.next();
			System.out.println();
			System.out.print("Put the category of the disc tou want to add: ");
			String category = scanner.next();
			System.out.println();
			System.out.print("Put the cost of the disc you want to add: ");
			float cost = scanner.nextFloat();
			System.out.println();
			System.out.println();
			Media disc = new Media(title, category, cost);
			store.addMedia(disc);
			updateStore();
		}
		else if (updateStore == 2) {
			System.out.print("Enter the tile of the dics you want to remove: ");
			String title = scanner.next();
			System.out.println();
			System.out.println("Removing ...");
			Media disc = store.TitleSearch(title);
			store.removeMedia(disc);
			updateStore();
		} 
		else if (updateStore == 0) {
			showMenu();
		}
		else {
			System.out.println("You must enter a valid number");
			updateStore();
		}
	}
	
	public static void cartMenu() {
		System.out.println("Options:  ");
		System.out.println("-------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Place order");
		System.out.println("5. Play a Media you want in the cart");
		System.out.println("0. Go Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int cartMenu = scanner.nextInt();
		
		if (cartMenu == 1) {
			if (cart.getsize() == 0) {
				System.out.println("Empty cart!");
				cartMenu();
			}
			System.out.println("Filtering continue... ");
			filterDVD();

		}
		else if (cartMenu == 2) {
			if (cart.getsize() == 0) {
				System.out.println("Empty cart!");
				cartMenu();
			}
			System.out.println("Sorting continue... ");
			sortDVD();
		}
		else if (cartMenu == 3) {
			if (cart.getsize() ==0){
				System.out.println("Empty cart!");
				cartMenu();
			}
			else{
			System.out.print("Enter the title of the DVD that you want to remove: ");
			String title = scanner.next();
			System.out.println();
			System.out.print("Removing...");
			Media disk = cart.TitleSearch(title);
			cart.removeMedia(disk);
			cartMenu();
			}
		}
		else if (cartMenu == 4) {
			if (cart.getsize() == 0) {
				System.out.println("Empty cart!");
				cartMenu();
			}
			else {
				cart.print();
				System.out.println("An order have been made!\n");
				if (cart.getsize()> 5){
				Media luckyItem = cart.getALuckyItem();
				System.out.println(String.format("Congratulation, you've just got a luckyItem which is free", luckyItem.getTitle()));
				cart.print();
				
				}
				cart.emptyCart();
				cartMenu();
			}
		}
		else if (cartMenu == 5){
			cart.print();
			System.out.println("Enter the tittle of media that you want to play: ");
			String title = scanner.next();
			Media media = cart.TitleSearch(title);
			if(media != null & media instanceof Playable){
				((Playable) media).play();
			}
			else{
				System.out.println("No media found!");
				
			}
			cartMenu();

		}


	}
	
	public static void filterDVD() {
		System.out.println("Options:  ");
		System.out.println("-------------------------");
		System.out.println("1. Filter Media by id");
		System.out.println("2. Filter Media by title");
		System.out.println("0. Go Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int filterDVD = scanner.nextInt();
		
		if (filterDVD == 1) {
			System.out.print("Enter the id of the Media that you want to find: ");
			int id = scanner.nextInt();
			System.out.println();
			System.out.println("Filtering... ");
			cart.IdSearch(id);
			System.out.println();
			filterDVD();
		}
		else if (filterDVD == 2) {
			System.out.print("Enter the title of the Media that you want to find: ");
			String title = scanner.next();
			System.out.println();
			System.out.println("Filtering");
			cart.TitleSearch(title);
			System.out.println();
			filterDVD();
		}
		else if (filterDVD == 0) {
			cartMenu();
		}
		else {
			System.out.println("You must enter a valid number");
			filterDVD();
		}
	}
	
	public static void sortDVD() {
		System.out.println("Options:  ");
		System.out.println("-------------------------");
		System.out.println("1. Sort Media by cost");
		System.out.println("2. Sort Media by title");
		System.out.println("0. Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int sortDVD = scanner.nextInt();
		
		if (sortDVD == 1) {
			
			cart.CostSort();
			System.out.println();
			sortDVD();
		}
		else if (sortDVD == 2) {
			cart.TitleSort();
			System.out.println();
			sortDVD();
		}
		else if (sortDVD == 0) {
			cartMenu();
		}
		else {
			System.out.println("You enter an invalid number");
			sortDVD();
		}
	

	
	}


	// public static void playFile() {
	// 	System.out.println("Options:  ");
	// 	System.out.println("-------------------------");
	// 	System.out.println("1. Play a Compact Disc");
	// 	System.out.println("2. Play a DigitalVideoDics");
	// 	System.out.println("0. Back");
	// 	System.out.println("-------------------------");
	// 	System.out.println("Please choose a number: 0-1-2");
	// 	System.out.println();
		
	// 	int playFile = scanner.nextInt();

	// 	if (playFile == 0){
	// 		storeMenu();
	// 	}

	// 	else if (playFile ==1){
	// 		System.out.println("Please enter the name of Compact Disc you want to play");

	// 	}
	// }
	// //Commememememetaetaemkamsfklmaklfmlsksmfklsamfklsamlksamlkk


	

}
