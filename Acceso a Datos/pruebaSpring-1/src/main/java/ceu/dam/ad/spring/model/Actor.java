package ceu.dam.ad.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
//@Table(name = "actores")
public class Actor {
	//primary key
	@Id
	//autogenerada primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//si el nombre de la columna es diferente
	@Column(name = "actor_id")
	private Long id;
	private String firstName;
	private String lastName;
	
}
