package ceu.dam.javafx.examen.gui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ceu.dam.javafx.examen.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {
	
	private static final String PATH_BASE = "/ceu/dam/javafx/examen/fxml/";
	public static final String FXML_CONSULTA_CATALOGO = PATH_BASE + "consultaCatalogo.fxml";
	public static final String FXML_CATALOGO = PATH_BASE + "catalogo.fxml";
	public static final String FXML_CONSULTA_PRECIO = PATH_BASE + "consultarPrecio.fxml";
	public static final String FXML_NUEVO_PRECIO = PATH_BASE + "nuevoPrecio.fxml";
	
	public static String PARAM_CATALOGO = "NEW_CATALOGO";
	protected static Stage primaryStage;
	
	public AppController() {
	}
	
	public AppController(Stage stage){
		primaryStage = stage;
	}
	
	public AppController changeScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			return loader.getController();
		}
		catch(IOException e) {
			throw new RuntimeException("Error cambiando escena.", e);
		}
	}
	
	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		}
		catch(IOException e) {
			throw new RuntimeException("Error cargando escena.", e);
		}
	}
	
	public void addParam(String key, Object param) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		if (mapa == null) {
			mapa = new HashMap<String, Object>();
			primaryStage.setUserData(mapa);
		}
		mapa.put(key, param);
	}
	
	public Object getParam(String key) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		return mapa.get(key);
	}
	
	public void mostrarErrror(String mensaje) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
	
}




