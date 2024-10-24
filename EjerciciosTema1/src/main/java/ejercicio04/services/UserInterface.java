package ejercicio04.services;

import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

import ejercicio04.modelo.User;

public interface UserInterface {
	
	public User  registerUser( User user) throws UserServiceException, ExistingUserException;
	
	public void changePass (Integer userId, String oldPass, String newPass) throws UserServiceException, NoMatchPaswwordsException;
	
	public User logIn (String userName, String passWord) throws UserServiceException, NoMatchPaswwordsException, UserDoesntExistException;
	
	public User checkUser(Connection conn,Integer id) throws UserServiceException, UserDoesntExistException;
	
	
}
