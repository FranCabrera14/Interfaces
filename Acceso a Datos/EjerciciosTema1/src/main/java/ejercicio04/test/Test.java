package ejercicio04.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio04.dao.UserDao;
import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;
import ejercicio04.modelo.User;
import ejercicio04.services.ExistingUserException;
import ejercicio04.services.NoMatchPaswwordsException;
import ejercicio04.services.PedidoNotFoundException;
import ejercicio04.services.PedidoService;
import ejercicio04.services.PedidoServiceException;
import ejercicio04.services.UserDoesntExistException;
import ejercicio04.services.UserService;
import ejercicio04.services.UserServiceException;

public class Test {
	 
	public static void main(String[] args) {
		
		UserService uS1 = new UserService();
		User user1;
		
		try {
			try {
				user1 = uS1.logIn("Extinthor", "alonso33");
				uS1.changePass(user1.getUserId(), "alonso33", "alonso34");
				System.out.println(user1);
			} catch (NoMatchPaswwordsException | UserDoesntExistException e) {
				
				e.printStackTrace();
			}		
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
		
}