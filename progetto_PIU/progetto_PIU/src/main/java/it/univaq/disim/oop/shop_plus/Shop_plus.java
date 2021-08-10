package it.univaq.disim.oop.shop_plus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Shop_plus extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/viste/login_PIU.fxml"));
		Parent login = loader.load();
		Scene scene= new Scene(login);
		stage.setScene(scene);
		stage.show();
	}

}

