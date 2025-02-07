package ceu.dam.ad.users.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id autogenerado del actor")
	private Long id;	
	private String username;
	private String email;
	private String password;
	@Column(name = "fecha_alta")
	private LocalDate createdDate;
	@Column(name = "fecha_ult_login")
	private LocalDate lastLoginDate;
	
	
	

}
