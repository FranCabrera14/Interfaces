package ceu.dam.javafx.examen.gui.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ceu.dam.javafx.examen.model.CatalogoPrecios;
import ceu.dam.javafx.examen.service.ExamenService;
import ceu.dam.javafx.examen.service.NotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.util.converter.LocalDateStringConverter;

public class ConsultaCatalogoController extends AppController {
	
	private ExamenService service;
	
 
    @FXML
    private ComboBox<String> combobox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField tfComercial;
    private CatalogoPrecios catalogo;
    private DateTimeFormatter formatter;
    

    @FXML
    void consultar(ActionEvent event) throws NumberFormatException, NotFoundException {
    	if(tfComercial.getText().isBlank()) {
    		mostrarErrror("Hay que indicar el comercial");
    	}else if ( combobox.getSelectionModel().getSelectedItem() == null) {
    		mostrarErrror("Hay que indicar la marca!!");
    	}else if (!tfComercial.getText().equals("1")) {
    		mostrarErrror("El catálogo está inactivo");
    	}else {
    		
    		LocalDate date = datePicker.getValue();
        catalogo = service.identificarCatalogo(Integer.parseInt(tfComercial.getText()), combobox.getSelectionModel().getSelectedItem(), date);
        addParam(FXML_CATALOGO, catalogo);
        changeScene(FXML_CATALOGO);
        	 
    	}
    	
    }
    
    @FXML
    public void initialize() {
    	service = new ExamenService();
    	combobox.getItems().addAll(service.consultarMarcas());
    	formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	datePicker.setConverter(new LocalDateStringConverter(formatter,formatter));
    	LocalDate fecha = LocalDate.now();
    	datePicker.setValue(fecha);
    	catalogo = new CatalogoPrecios();
       
    	
    }

}

