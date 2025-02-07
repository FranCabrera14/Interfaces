package ceu.dam.ad.mongo.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CreateClientRequest {
	@NotBlank(message = "El dni no debe estar en blanco")
	@Size(min = 9)
	private String dni;
	@NotBlank(message = "El nombre no debe estar en blanco")
	private String nombre;
	@NotBlank(message = "La direccion no debe estar en blanco")
	private String direccion;
}
