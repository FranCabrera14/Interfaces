package ceu.dam.ad.users.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CreateUserRequest {

	@NotNull
	@Size(min = 3, max = 50)
	@NotBlank(message = "El nombre es obligatorio")
	private String username;
	@Email
	@NotNull
	@Size(min = 3, max = 50)
	@NotBlank(message = "El correo es obligatorio")
	private String email;
	@NotNull
	@Size(min = 4)
	@NotBlank(message = "La contraseña es obligatoria")
	private String password;
}
