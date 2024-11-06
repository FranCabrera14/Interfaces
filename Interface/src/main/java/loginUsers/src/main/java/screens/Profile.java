package screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MainController;
import ejercicio04.modelo.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JTextField emailField;
	private MainController mainController;
	private JTextField logInField;
	private JTextField SignUpField;
	private JButton btnLogOut;

	/**
	 * Create the panel.
	 */
	public Profile(MainController mainController) {
		this.mainController = mainController;
		setLayout(null);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(48, 75, 79, 14);
		add(lblUserName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(48, 118, 79, 14);
		add(lblEmail);
		
		JLabel lblLogInDate = new JLabel("Last log in:");
		lblLogInDate.setBounds(48, 160, 68, 14);
		add(lblLogInDate);
		
		JLabel lblSignUpDate = new JLabel("Sign Up date:");
		lblSignUpDate.setBounds(48, 206, 104, 14);
		add(lblSignUpDate);
		
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setColumns(10);
		usernameField.setBounds(188, 75, 113, 20);
		add(usernameField);
		
		
		emailField = new JTextField();
		emailField.setEditable(false);
		emailField.setColumns(10);
		emailField.setBounds(188, 118, 113, 20);
		add(emailField);
		
		JButton btnChangePass = new JButton("Change Password");
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.goToChangePassScreen();
			}
		});
		btnChangePass.setBounds(270, 249, 131, 23);
		add(btnChangePass);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Verdana", Font.BOLD, 20));
		lblProfile.setBounds(167, 11, 113, 28);
		add(lblProfile);
		
		logInField = new JTextField();
		logInField.setEditable(false);
		logInField.setColumns(10);
		logInField.setBounds(188, 157, 113, 20);
		add(logInField);
		
		SignUpField = new JTextField();
		SignUpField.setEditable(false);
		SignUpField.setColumns(10);
		SignUpField.setBounds(188, 203, 113, 20);
		add(SignUpField);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.LogOut();
			}
		});
		btnLogOut.setBounds(63, 249, 118, 23);
		add(btnLogOut);
		
	
		

	}
	
	public void setUserName(String userName) {
		usernameField.setText(userName);
	}
	public void setEmail(String email) {
		emailField.setText(email);
	}
	public void setLogInDate(String logInDate) {
		logInField.setText(logInDate);
	}
	public void setSignUpDate (String signUpDate) {
		SignUpField.setText(signUpDate);
	}
	

}
