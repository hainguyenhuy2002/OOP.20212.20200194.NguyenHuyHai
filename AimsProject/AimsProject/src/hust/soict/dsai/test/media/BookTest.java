package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("Life_Of_Pi", "Mystery", 5.6f, "This book is about the life and adventure of Pi, and also about animals aswell!");
		book.addAuthor("Yan Martel");
		book.addAuthor("Piscine Patel");

		System.out.println(book.toString());
		System.out.println(book.getContentTokens());
		System.out.println(book.getWordFrequency());
	}

}
