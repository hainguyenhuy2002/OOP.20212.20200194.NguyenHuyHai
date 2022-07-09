package hust.soict.dsai.test.screen.customer.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.track.Track;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application{
	private static Store store;
	private static Cart cart;
	
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		CartController cartController = new CartController(cart, store);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) {
		cart = new Cart();
		store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Toy Story", "Animation", "Disney Corp", 180, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Mr.Bean", "Comedy", "Universal Corp", 90, 10.8f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Zed", "Action", "Guy Ritchie", 120, 25.45f);
		
		Book book = new Book("Life Of Pi", "Mystery", 5.6f, "This book is about the life and adventure of Pi");
		book.addAuthor("Yan Martel");
		book.addAuthor("Piscine Patel");
		
		Track track1 = new Track("Beat It", 4);
		Track track2 = new Track("Around the world", 6);
		CompactDisc cd = new CompactDisc("Legacy - Michael Jackson", "Remaster", "Jordan Peele", 10, 30.5f, "Michael Jackson");
		cd.addTrack(track1);
		cd.addTrack(track2);
		
		cart.addMedia(dvd1);
        cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(book);
        cart.addMedia(cd);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book);
        store.addMedia(cd);


		launch(args);
	}

}
