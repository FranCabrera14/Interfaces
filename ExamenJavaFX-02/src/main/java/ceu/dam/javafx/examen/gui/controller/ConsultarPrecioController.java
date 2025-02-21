package ceu.dam.javafx.examen.gui.controller;

import java.awt.Color;
import java.util.List;

import ceu.dam.javafx.examen.model.CatalogoPrecios;
import ceu.dam.javafx.examen.model.Coche;
import ceu.dam.javafx.examen.service.ExamenService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultarPrecioController extends AppController {

    @FXML
    private CheckBox checkBox;

    @FXML
    private TableColumn<Coche, Color> color;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Label lblCatalogo;

    @FXML
    private TableColumn<Coche, String> matricula;

    @FXML
    private TableColumn<Coche, Integer> precio;

    @FXML
    private TableView<Coche> tabla;
    
    private CatalogoPrecios catalogo;
    private ExamenService service;
    
    private ObservableList<Coche> datos;
    @FXML
    void consultar(ActionEvent event) {
    	List<Coche> lista = service.consultarPrecios(catalogo.getIdCatalogo());

			datos.setAll(lista);
    }

    @FXML
    void select(ActionEvent event) {
    	colorPicker.setDisable(true);
    }
    @FXML
    public void initialize() {
    	service = new ExamenService();
    	catalogo = (CatalogoPrecios) getParam(FXML_CATALOGO);
    	lblCatalogo.setText(catalogo.toString());
    	matricula.setCellValueFactory(new PropertyValueFactory("matricula"));
    	precio.setCellValueFactory(new PropertyValueFactory("precio"));
    	color.setCellValueFactory(new PropertyValueFactory("color"));
    	datos = FXCollections.observableArrayList();
    	tabla.setItems(datos);
    }

}
