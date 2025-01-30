package ceu.dam.ad.spring.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Data
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id autogenerado del actor")
	private Long actorId;
	@NotNull
	@Size(min = 3, max = 45)
	@NotBlank(message = "El nombre es obligatorio")
	private String firstName;
	@NotNull
	@Size(min = 3, max = 45)
	@NotBlank(message = "El apellido es obligatorio")
	private String lastName;
	@PastOrPresent
	private LocalDate lastUpdate;
}
