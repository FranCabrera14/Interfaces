package ejercicio04.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mariadb.jdbc.Connection;

import ejercicio04.modelo.Pedido;
import ejercicio04.modelo.User;
import ejercicio04.services.UserInterface;

public class UserDao {

	public Integer insertUser(Connection conn, User user) throws SQLException {

		String sql = "INSERT INTO usuarios (username, password, email, fecha_alta, fecha_ult_login)  values (?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, Date.valueOf(user.getSignUpDate()));
			stmt.setDate(5, Date.valueOf(user.getLogInDate()));
			stmt.executeUpdate();

			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			return keys.getInt(1);

		}

	}

	public User getById(Connection conn, Integer idUser) throws SQLException {
		String sql2 = "select * from usuarios where ID = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
			stmt.setInt(1, idUser);

			return get(stmt);

		}

	}

	public User getByEmail(Connection conn, String email) throws SQLException {
		String sql2 = "select * from usuarios where email = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
			stmt.setString(1, email);

			return get(stmt);

		}

	}

	public User getByUser(Connection conn, String userName) throws SQLException {
		String sql2 = "select * from usuarios where username = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
			stmt.setString(1, userName);

			return get(stmt);

		}

	}

	private User get(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			User userChecked = new User();

			userChecked.setUserId(rs.getInt("ID"));
			userChecked.setUserName(rs.getString("username"));
			userChecked.setPassword(rs.getString("password"));
			userChecked.setEmail(rs.getString("email"));
			userChecked.setSignUpDate(rs.getDate("fecha_alta").toLocalDate());
			userChecked.setLogInDate(rs.getDate("fecha_ult_login").toLocalDate());

			return userChecked;
		}
		return null;
	}

	public Integer updateUser(Connection conn, User user) throws SQLException {

		String sql3 = "update usuarios set username = ? , password = ?, email = ?, fecha_ult_login = ? WHERE ID = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql3)) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, Date.valueOf(user.getLogInDate()));
			Integer rowsUpdated = stmt.executeUpdate();
			return rowsUpdated;

		}

	}

}
