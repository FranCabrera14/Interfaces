package ceu.dam.ad.users.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequest {
	@NotBlank
	@NotNull
	private Long userId;
	@NotNull
	@Size(min = 8, max = 100)
	@NotBlank(message = "La antigua contraseña es obligatoria")
	private String oldPassword;
	@NotNull
	@Size(min = 8, max = 100)
	@NotBlank(message = "La nueva contraseña es obligatoria")
	private String newPassword;

}
