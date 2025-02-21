package ceu.dam.javafx.examen;

import ceu.dam.javafx.examen.gui.controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController controller = new AppController(primaryStage);
		controller.changeScene(AppController.FXML_CONSULTA_CATALOGO);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();
		
	}
	
	

}