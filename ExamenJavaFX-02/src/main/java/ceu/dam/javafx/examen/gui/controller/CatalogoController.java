package ceu.dam.javafx.examen.gui.controller;

import java.util.Optional;

import ceu.dam.javafx.examen.model.CatalogoPrecios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
public class CatalogoController extends AppController {
	@FXML
	private BorderPane borderPane;
	@FXML
	private Label lblCatalogo;
	private CatalogoPrecios catalogo;

	@FXML
	void goConsultarPrecios(ActionEvent event) {
		borderPane.setCenter(loadScene(FXML_CONSULTA_PRECIO));
	}

	@FXML
	void goInicio(ActionEvent event) {
		Alert pregunta = new Alert(AlertType.CONFIRMATION);
		pregunta.setContentText("¿Estás seguro de que quieres cerrar el catálogo?");
		pregunta.setTitle("Cerrar");
		pregunta.setHeaderText(null);
		Optional<ButtonType> respuesta = pregunta.showAndWait();
		if (respuesta.get() == ButtonType.OK) {
			changeScene(FXML_CONSULTA_CATALOGO);
		}
	}

	@FXML
	void goPrecioNuevo(ActionEvent event) {
		borderPane.setCenter(loadScene(FXML_NUEVO_PRECIO));
	}

	@FXML
	void salir(ActionEvent event) {
		Alert pregunta = new Alert(AlertType.CONFIRMATION);
		pregunta.setContentText("¿Estás seguro de que quieres salir?");
		pregunta.setTitle("Salir");
		pregunta.setHeaderText(null);
		Optional<ButtonType> respuesta = pregunta.showAndWait();
		if (respuesta.get() == ButtonType.OK) {
			System.exit(0);
		}
	}
	
	public void initialize( ) {
		addParam("BORDER_PANE", borderPane);
		catalogo = (CatalogoPrecios) getParam(FXML_CATALOGO);
		lblCatalogo.setText(catalogo.toString());
		
	}
	
	

}
