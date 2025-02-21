package ceu.dam.examen.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Oficina {
	@Id
	@NotBlank
	private String codigo; // no puede ser blanco
	@NotBlank
	private String ciudad; // no puede ser blanco
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
