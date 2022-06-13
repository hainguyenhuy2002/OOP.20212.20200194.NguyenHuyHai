package hust.soict.dsai.test.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;


public class TestMediaCompareTo {
	public static void main(String[] args) {
		ArrayList<Media> collection = new ArrayList<Media>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Disney Corp", 200, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("FAST AND FURIOUS", "ACTION", "Universal Corp", 100, 10.8f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("YASUO", "GAME", " RIOT", 120, 25.45f);
	
		dvd1.play();
		dvd2.play();
		dvd3.play();
		
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		java.util.Collections.sort((java.util.List)collection);
		
		iterator = collection.iterator();
		
		System.out.println("------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		System.out.println("------------------");
	}
}