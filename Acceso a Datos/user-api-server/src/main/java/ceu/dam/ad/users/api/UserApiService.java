package ceu.dam.ad.users.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserNotFoundException;
import ceu.dam.ad.users.service.UserService;
import ceu.dam.ad.users.service.UserUnauthorizedException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "Authorization")
public class UserApiService {
	@Autowired
	private UserService service;
	@PostMapping
	@Operation(summary = "Creacion  de usuarios", description = "Crear un usuario")
	public User crear(@Valid @RequestBody CreateUserRequest request) throws UserNotFoundException, DuplicateUserException, UserException {
		User user = new User();
		//como la fecha de alta, id y login es autogenerado, se recibe un objeto creado solo con el 
		//username. email y password, y como al servicio tengo que pasarle un user, me lo creo
		//y le pongo todos los datos, en vez de monerlos con user.set usamos el modelMapper
		//y esto copia todos los atributos del request al user.
		ModelMapper mapper = new ModelMapper();
		mapper.map(request, user);
		return service.createUser(user);
	}
	@PutMapping
	@Operation(summary = "Cambio de contraseña", description = "Método para cambiar la contraseña del usuario")
	public void changePassword(@RequestBody ChangePasswordRequest request) throws UserNotFoundException, UserUnauthorizedException, UserException {
		service.changePassword(request.getUserId(), request.getOldPassword(), request.getNewPassword());
	}	
	@GetMapping("/login")
	@Operation(summary = "Login de usuario", description = "Método para que el usuario haga login con su contraseña y usuario.")
	public User login(@Valid @RequestParam() String username,@Valid @RequestParam() String password) throws UserNotFoundException, UserUnauthorizedException, UserException {
		return service.login(username, password);
		
	}
	@GetMapping("/{idUser}")
	@Operation(summary = "Solicitar usuario", description = "Método para comprobar un usuario por id")
	public User getById(@PathVariable Long idUser) throws UserNotFoundException, UserException {
		return service.getUser(idUser);
	}


}
