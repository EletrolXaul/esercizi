package it.univaq.disim.oop.myunivaq.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.univaq.disim.oop.myunivaq.business.BusinessException;
import it.univaq.disim.oop.myunivaq.business.MyUnivaqBusinessFactory;
import it.univaq.disim.oop.myunivaq.business.UtenteNotFoundException;
import it.univaq.disim.oop.myunivaq.business.UtenteService;
import it.univaq.disim.oop.myunivaq.domain.Utente;
import it.univaq.disim.oop.myunivaq.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable, DataInitializable<Object> {

	@FXML
	private Label loginErrorLabel;
	
	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button loginButton;
	
	private UtenteService utenteService;

	private ViewDispatcher dispatcher;
	
	public LoginController() {
		MyUnivaqBusinessFactory factory = MyUnivaqBusinessFactory.getInstance();
		utenteService = factory.getUtenteService();
		
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginButton.disableProperty().bind(username.textProperty().isEmpty().or(password.textProperty().isEmpty()));
	}

	@FXML
	public void loginAction(ActionEvent event) {
		try {
			Utente utente = utenteService.authenticate(username.getText(), password.getText());
			dispatcher.loggedIn(utente);
		} catch (UtenteNotFoundException e) {
			loginErrorLabel.setText("Username e/o password errati!");
		} catch (BusinessException e) {
			dispatcher.renderError(e);
		}
	}
}
