package ceu.dam.ad.spring.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
public class Conductor {
	@Id
	@GeneratedValue
	@JdbcTypeCode(value = java.sql.Types.VARCHAR)
	@Schema(description = "Identificador  autogenerado del conductor. No es obligatorio en peticiones post")
	private UUID uuidConductor;
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 4)
	private String nombre;
	@NotNull(message = "La edad es obligatoria")
	@Min(value = 18, message = "La edad tiene que ser mayor de 18")
	private Integer edad;

}
