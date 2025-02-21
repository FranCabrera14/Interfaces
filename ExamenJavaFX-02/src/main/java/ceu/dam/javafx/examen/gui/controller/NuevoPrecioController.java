package ceu.dam.javafx.examen.gui.controller;

import ceu.dam.javafx.examen.model.CatalogoPrecios;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NuevoPrecioController extends AppController {

    @FXML
    private Label lblCatalogo;
    
 
    
    private CatalogoPrecios catalogo;
    
    
    @FXML
    void initialize() {
    	catalogo = (CatalogoPrecios) getParam(FXML_CATALOGO);
    	lblCatalogo.setText(catalogo.toString());
    }

}

