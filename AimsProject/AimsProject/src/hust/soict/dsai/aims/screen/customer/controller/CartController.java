package hust.soict.dsai.aims.screen.customer.controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;

public class CartController {
    private Cart cart;
    private Store store;
    public CartController(Cart cart, Store store){
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		costLabel.setText(cart.totalCost() + " $");
		store.addMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }   


    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
        costLabel.setText(cart.totalCost() + " $");

        btnPlay.setVisible(false);
	    btnRemove.setVisible(false);
	    
	    tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            
        
	    	public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
	    		updateButtonBar(newValue);
	    	}

			public void updateButtonBar(Media media) {
				if (media == null) {
					btnPlay.setVisible(false);
					btnRemove.setVisible(false);
				} else {
					btnRemove.setVisible(true);
					if (media instanceof Playable) {
						btnPlay.setVisible(true);
					} else {
						btnPlay.setVisible(false);
					}
				}
			}
	    });

    }

}

