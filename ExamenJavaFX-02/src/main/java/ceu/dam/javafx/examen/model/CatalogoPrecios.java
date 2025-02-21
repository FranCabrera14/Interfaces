package ceu.dam.javafx.examen.model;

import java.time.LocalDate;

public class CatalogoPrecios {

	private Integer idCatalogo;
	private Integer idComercial;
	private String marca;
	private LocalDate fecha;
	
	public CatalogoPrecios() {
	}
	
	public CatalogoPrecios(Integer idCatalogo, Integer idComercial, String marca, LocalDate fecha) {
		super();
		this.idCatalogo = idCatalogo;
		this.idComercial = idComercial;
		this.marca = marca;
		this.fecha = fecha;
	}


	public Integer getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public Integer getIdComercial() {
		return idComercial;
	}
	public void setIdComercial(Integer idComercial) {
		this.idComercial = idComercial;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	@Override
	public String toString() {
		return "Catálogo ID " + idCatalogo + " (Comercial: " + idComercial + ") " + marca + " - " + fecha;
	}
	
	
}
