package ceu.dam.examen.api;

import lombok.Data;

@Data
public class EmpleadoRequest {
	private String dni;
	private String nombreCompleto;
	private String codEmpresa;
}
