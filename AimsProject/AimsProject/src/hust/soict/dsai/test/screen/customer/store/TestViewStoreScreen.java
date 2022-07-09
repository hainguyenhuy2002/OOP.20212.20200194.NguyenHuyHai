package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
    private static Store store;
    private static Cart cart;



    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";   
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String args[]) {
		store = new Store();
		cart = new Cart();
		
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
		
		store.addMedia(new Book("Harry Potter", "", 10.99f, ""));
		
		launch(args);
	}
    
}
