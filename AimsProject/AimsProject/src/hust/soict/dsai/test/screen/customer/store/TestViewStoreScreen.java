package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.memory.MemoryDaemon;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.track.Track;
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
		Thread thread = new Thread(new MemoryDaemon());
		thread.setDaemon(true);
		thread.start();

		DigitalVideoDisc media1 =  new DigitalVideoDisc("One Punch Man", "Science Fiction", "Huy Hai", 87, 27.95f);
		store.addMedia(media1);

		Track track1 = new Track("SHAY NANG", 4);
		Track track2 = new Track("22", 6);
		CompactDisc mediahihi = new CompactDisc("YouTube", "Horror", "Still Huy Hai",100, 50.65f, "AMEE");
		mediahihi.addTrack(track1);
		mediahihi.addTrack(track2);
		store.addMedia(mediahihi);

		
		store.addMedia(new DigitalVideoDisc("Naruto", "Action", "Anya", 85, 19.02f));

		store.addMedia(new DigitalVideoDisc("Sasukeeee", "Action", "Anya", 85, 19.02f));

		DigitalVideoDisc media2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media2);
		
		DigitalVideoDisc media3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(media3);
		
		DigitalVideoDisc media4 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media4);

		Track track3 = new Track("Anh quat em a", 4);
		Track track4 = new Track("Tam giac la tac giam", 6);
		CompactDisc cd2 = new CompactDisc("Video Tik Tok", "Entertainment", "Huy Hai", 10, 30.5f, "Le Bong");
		cd2.addTrack(track3);
		cd2.addTrack(track4);
		store.addMedia(cd2);
		
		store.addMedia(new Book("Harry Potter", "", 10.99f, ""));
		
		launch(args);
	}
    
}
