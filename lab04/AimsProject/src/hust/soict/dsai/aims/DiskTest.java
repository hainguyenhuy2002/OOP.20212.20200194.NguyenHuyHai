package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class DiskTest {
    public static void main(String[] args) {
		// create a cart
		Cart cart = new Cart();
		
		// create some disk
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Hai the handsome boy", "Action", "Huy Hai", 100, 20.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BlackHole", "Science Fiction", "Hai-the-proffesor", 87, 26.65f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		
		
		//check isMatch() method of the DigitalVideoDisc class
		System.out.println(dvd3.isMatch("Aladin 3")); //true
		System.out.println(dvd1.isMatch("Queen")); //false
		
		
		//check the search method of the cart
		
		
		//search by id
		cart.IdSearch(0); //No such disc found with that id!
		cart.IdSearch(1);
        cart.IdSearch(2);
        cart.IdSearch(3);
		
		//search by title
		cart.TitileSearch("Aladin");
		//Disk found with the title: Aladin!
		//3. DVD-Aladin-Animation-null-0: 18.99$
		cart.TitileSearch("Handsome");
		//No such dics found with the title: Queen!
	}
}
