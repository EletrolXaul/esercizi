//da modificare ed adattare

package it.univaq.disim.oop.shop_plus.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private Label loginErrorLabel;
	
	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button loginButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginButton.disableProperty().bind(username.textProperty().isEmpty().or(password.textProperty().isEmpty()));
	}
	
	@FXML
	private void loginAction (ActionEvent event) {
		if(!("cliente".equals(username.getText()) && ("cliente".equals(password.getText())))) {
			loginErrorLabel.setText("Username e/o password errati!");
			} else {
				//Bisogna caricare la vista successiva
		}
	}
}
 