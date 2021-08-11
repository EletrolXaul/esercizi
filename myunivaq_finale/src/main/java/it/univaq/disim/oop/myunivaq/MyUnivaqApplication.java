package it.univaq.disim.oop.myunivaq;

import it.univaq.disim.oop.myunivaq.view.ViewDispatcher;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyUnivaqApplication extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
        ViewDispatcher dispatcher = ViewDispatcher.getInstance();
        dispatcher.loginView(stage);
	}

}
