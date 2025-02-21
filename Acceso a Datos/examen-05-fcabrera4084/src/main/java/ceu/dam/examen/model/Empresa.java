package ceu.dam.examen.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Empresa {
	@Id
	@NotBlank(message = "el codigo no puede ser blanco")
	@Column(name = "cod_empresa")
	private String codigo; // no puede ser blanco
	@NotBlank(message = "el nombre  no puede ser blanco")
	@Column(name = "nombre_comercial")
	private String nombreComercial;  // no puede ser blanco
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ceo")
	private Ceo ceo;  // no puede ser null
	@Size(min = 1 , message = "debe haber al menos una oficina")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_empresa", nullable = false)
	private List<Oficina> oficinas; // no puede ser null y debe de tener al menos 1 oficina
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public Ceo getCeo() {
		return ceo;
	}
	public void setCeo(Ceo ceo) {
		this.ceo = ceo;
	}
	public List<Oficina> getOficinas() {
		return oficinas;
	}
	public void setOficinas(List<Oficina> oficinas) {
		this.oficinas = oficinas;
	}
	

	
	
}
