package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("Life_Of_Pi", "Mystery", 5.6f, "Yolo, this is a title naruto, sauke, obitooooo");
		book.addAuthor("Sea");
		book.addAuthor("TV");

		System.out.println(book.toString());
		System.out.println(book.getContentTokens());
		System.out.println(book.getWordFrequency());
	}

}
