package ceu.dam.ad.api.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserService;

@SpringBootTest
@ActiveProfiles("test")
class AppTests {
	@Autowired
	private UserService service;
	
	@Test
	void testCrearUser() throws DuplicateUserException, UserException{
		User user = new User();
		user.setUsername("Cahlos test");
		user.setEmail("email test");
		user.setPassword("password test");
		User userCreado = service.createUser(user);
		
		
		
	}
}
