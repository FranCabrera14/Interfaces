package ejercicio04.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
	public User() {
	}
	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private LocalDate signUpDate;
	private LocalDate logInDate;
	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	

}
