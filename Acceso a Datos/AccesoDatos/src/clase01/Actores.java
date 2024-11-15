package clase01;

import lombok.Data;

public @Data class Actores {
	private Integer actorId;
	private String 	firstName;
	private String  lastName;
	
	@Override
	public String toString() {
		return "Actores: << ID-> " + actorId + " || NOMBRE-> " + firstName + " || APELLIDOS-> " + lastName + " >>";
	}
	
}
