package hust.soict.dsai.aims.screen.customer.controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
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
    private RadioButton radioBtnFilterId;

    @FXML 
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if (media instanceof Playable) {
    		try {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Playing media");
        		alert.setHeaderText("Media infomation: ");
    			alert.setContentText(((Playable) media).play());
        		alert.showAndWait();
    		} catch (PlayerException  | ClassCastException e) {
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Playing failed");
        		alert.setHeaderText("Error infomation: ");
    			alert.setContentText(e.getMessage());
        		alert.showAndWait();
			}
    	}
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
        try {
    		final String PLAYABLE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLAYABLE_FXML_FILE_PATH));
        	fxmlLoader.setController(new ViewStoreController(store, cart));
        	Parent root = fxmlLoader.load();
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }   


    @FXML
    void btnPlaceOrderButtonPressed(ActionEvent event) {
    	Alert alert;
    	alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Order Confirmation!!!");
		alert.setHeaderText("Would you like to place these oreders??");
		Optional<ButtonType> result = alert.showAndWait();
		if(!result.isPresent()) {
			// alert is exited, no button has been pressed.
		} else if(result.get() == ButtonType.OK) {
        
        if (cart.getItemsOrdered().size() > 0) {
			cart.emptyCart();
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Notice");
			alert1.setHeaderText("Successful!");
			alert1.setContentText("Your order has successfully been placed!");
			alert1.showAndWait();
    	} else {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Notice");
			alert1.setHeaderText("ERROR: Failed!");
			alert1.setContentText("You don't have any cart!");
			alert1.showAndWait();
    	}
    }
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
	    });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
	     	@Override
	     	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	     		showFilteredMedia(newValue);
	     	}
         });
	    	

    }



    private void updateButtonBar(Media media) {
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

    public void showFilteredMedia(String newValue) {
        String tfString = newValue.toLowerCase();
        ObservableList<Media> filteredList = FXCollections.observableArrayList();
        if (cart.getItemsOrdered() != null) {
        if (tfString.equals("")) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        else {
            for (Media row: tblMedia.getItems()) {
                if (((RadioButton) filterCategory.getSelectedToggle()).getText().equals(radioBtnFilterId.getText())) {
                    //need some exception handling here
                    try {
                        if (row.getId() == Integer.parseInt(tfString)) {
                            filteredList.add(row);
                        }
                    } catch (NumberFormatException e){
                        //ignore
                    }
                }
                
                if (((RadioButton) filterCategory.getSelectedToggle()).getText().equals(radioBtnFilterTitle.getText())) {
                    if (row.getTitle().toLowerCase().contains(tfString)) {
                        filteredList.add(row);
                    }
                }
            }
            
            FilteredList<Media> filteredData = new FilteredList<>(filteredList, p -> true);
            tblMedia.setItems(filteredData);
        }
    }
    }
}

