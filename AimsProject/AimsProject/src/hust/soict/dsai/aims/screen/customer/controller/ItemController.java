package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import javax.naming.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
    private Store store;
    private Media media;
	private Cart cart;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    public void btnAddToCartClicked(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Add Media");
    	alert.setHeaderText("Add Media Status:");
        cart.addMedia(media);
        try {
			cart.addMedia(media);
		} catch (FullCartException e) {
    		Alert alert1 = new Alert(AlertType.ERROR);
    		alert1.setTitle("Adding failed");
    		alert1.setHeaderText("Error infomation: ");
			alert1.setContentText(e.getMessage());
    		alert1.showAndWait();
		}
        alert.showAndWait();


    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	if (media instanceof Playable) {
    		try {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Playing media");
        		alert.setHeaderText("Media infomation: ");
    			alert.setContentText(((Playable) media).play());
        		alert.showAndWait();
    		} catch (ClassCastException e) {
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Playing failed");
        		alert.setHeaderText("Error infomation: ");
    			alert.setContentText(e.getMessage());
        		alert.showAndWait();
			}
    	}
    }

    public void setData(Media media, Cart cart) {
    	this.media = media;
        this.cart = cart;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(true);
    		HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
    	}
    }


}
