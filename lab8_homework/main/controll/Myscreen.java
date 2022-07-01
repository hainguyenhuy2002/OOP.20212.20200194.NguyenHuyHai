package main.controll;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Myscreen extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/main/screen/screen.fxml"));
            
            stage.setTitle("My Application");
            stage.setScene(new Scene(root, 440, 380));
            stage.setMinWidth(200);
            stage.setMinHeight(200);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
