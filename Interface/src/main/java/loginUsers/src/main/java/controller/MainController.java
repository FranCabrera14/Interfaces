package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.checkerframework.checker.initialization.qual.Initialized;

import ejercicio04.dao.UserDao;
import ejercicio04.modelo.User;
import ejercicio04.services.ExistingUserException;
import ejercicio04.services.NoMatchPaswwordsException;
import ejercicio04.services.UserDoesntExistException;
import ejercicio04.services.UserService;
import ejercicio04.services.UserServiceException;
import screens.ChangePass;
import screens.LogIn;
import screens.MainScreen;
import screens.Profile;
import screens.SignUp;

public class MainController extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainScreen mainScreen;
	private JPanel logInScreen;
	private JPanel signUpScreen;
	private JPanel changePassScreen;
	private JPanel profileScreen;
	private final UserService us = new UserService();
	private User userSession;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainController frame = new MainController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainController() {
		mainScreen = new MainScreen(this);
		logInScreen = new LogIn(this);
		signUpScreen = new SignUp(this);
		profileScreen = new Profile(this);
		changePassScreen = new ChangePass(this);
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 500, 350);
		setContentPane(mainScreen);
	}

	public void goToLogInScreen() {
		clearTextFields(logInScreen);
		setContentPane(logInScreen);
		revalidate();
		
	}
	
	public void goToSignUpScreen() {
		clearTextFields(signUpScreen);
		setContentPane(signUpScreen);
		revalidate();
	}
	
	public void goToProfileScreen() {
		setContentPane(profileScreen);
		profile();
		revalidate();
	}
	
	public void goToChangePassScreen() {
		clearTextFields(changePassScreen);
		setContentPane(changePassScreen);
		revalidate();
	}
	
	public void goToMainScreen() {
		setContentPane(mainScreen);
		userSession = null;
		revalidate();
	}
	
	public void submitLogin(String userName, String Password)  {
		try {
			userSession = us.logIn(userName, Password);
			goToProfileScreen();
			
		} catch (UserServiceException | NoMatchPaswwordsException | UserDoesntExistException e) {
			JOptionPane.showMessageDialog(this, "Data entered is not correct");
			
			
		}
	}
	
	public void submitSignUp(String username, String password, String email) {
		User userNew = new User();
		userNew.setUserName(username);
		userNew.setPassword(password);
		userNew.setEmail(email);
		try {
			userSession = us.registerUser(userNew);
			goToProfileScreen();
		} catch (UserServiceException | ExistingUserException e) {
			e.printStackTrace();
		}
	
	}
	
	public void submitChangePass(String oldPass, String newPass) {

		try {
			JOptionPane.showConfirmDialog(this, "Are you sure you want to change the password?");
			us.changePass(userSession.getUserId(), oldPass, newPass);
			goToProfileScreen();
			JOptionPane.showMessageDialog(this, "Password has changed succesfully!");
		} catch (UserServiceException | NoMatchPaswwordsException e) {
			JOptionPane.showMessageDialog(mainScreen, "Error passwords dont match");
			
		}
	}
	
	public void profile() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String registerDate = formatter.format(userSession.getSignUpDate());
		String logInDate = formatter.format(userSession.getLogInDate());
		((Profile) profileScreen).setUserName(userSession.getUserName());
		((Profile) profileScreen).setEmail(userSession.getEmail());
		((Profile) profileScreen).setLogInDate(logInDate);
		((Profile) profileScreen).setSignUpDate(registerDate);
	}
	
	public void LogOut() {
		goToMainScreen();
		
	}
	
	private void clearTextFields(JPanel panel) {
		for (Component component : panel.getComponents()) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
	}

}
