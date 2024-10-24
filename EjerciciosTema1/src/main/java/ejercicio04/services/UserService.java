package ejercicio04.services;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;
import org.mariadb.jdbc.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejercicio04.dao.UserDao;
import ejercicio04.modelo.User;

public class UserService extends Services implements UserInterface {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	@Override
	public User registerUser(User user) throws UserServiceException, ExistingUserException {
		try (Connection conn = abrirConexion()) {
			User u1 = userDao.getByUser(conn, user.getUserName());
			User u2 = userDao.getByEmail(conn, user.getUserName());

			if (u1 == null && u2 == null) {
				log.debug("Creando nuevo usuario...");
				user.setUserId(userDao.insertUser(conn, user));
			} else {
				log.warn("usuario ya existente...");
				throw new ExistingUserException("Ya existe un usuario con ese USERNAME o EMAIL");

			}

		} catch (SQLException e) {
			log.error("Error registrando usuario", e);
			throw new UserServiceException();

		}

		return user;
	}

	@Override
	public void changePass(Integer userId, String oldPass, String newPass)
			throws UserServiceException, NoMatchPaswwordsException {
		try (Connection conn = abrirConexion()) {
			User u1 = userDao.getById(conn, userId);
			if (u1 != null) {
				log.debug("cambiando contraseña...");
				if (u1.getPassword().equals(DigestUtils.sha256Hex(oldPass))) {
					u1.setPassword(DigestUtils.sha256Hex(newPass));
					log.debug("Contraseña cambiada...");
				} else {
					log.warn("La contraseña no coincide...");
					throw new NoMatchPaswwordsException();
				}

			} else {
				log.warn("No existe ese usuario...");
				throw new UserServiceException();
			}
		} catch (SQLException e) {
			log.error("Error cambiando contraseña", e);
			e.printStackTrace();
			throw new UserServiceException();
		}
	}

	@Override
	public User logIn(String userName, String passWord)
			throws UserServiceException, NoMatchPaswwordsException, UserDoesntExistException {
		try (Connection conn = abrirConexion()) {
			User u1 = userDao.getByUser(conn, userName);
			if (u1 == null) {
				log.debug("El userName no existe...");
				throw new UserDoesntExistException();
			}

		} catch (SQLException e) {
			log.error("Error en el  log in", e);
			e.printStackTrace();
			throw new UserServiceException();
		}

		return null;
	}

	@Override
	public User checkUser(Connection conn, Integer id) throws UserServiceException, UserDoesntExistException {
		try (Connection conn1 = abrirConexion()) {
			User u1 = userDao.getById(conn, id);
			if (u1 == null) {
				log.debug("El user no existe...");
				throw new UserDoesntExistException();
			}
		} catch (SQLException e) {
			log.error("Error al buscar el usuario", e);
			e.printStackTrace();
			throw new UserServiceException();
		}

		return null;
	}

}
