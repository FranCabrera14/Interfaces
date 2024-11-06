package screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.MainController;
import ejercicio04.modelo.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private MainController mainController;
	private JPasswordField passwordField01;
	private JPasswordField passwordField02;
	private User user;

	/**
	 * Create the panel.
	 */
	public SignUp(MainController mainContoller) {
		this.mainController = mainContoller;
		setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign up");
		lblSignUp.setFont(new Font("Verdana", Font.BOLD, 20));
		lblSignUp.setBounds(154, 11, 113, 28);
		add(lblSignUp);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(49, 60, 79, 14);
		add(lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(169, 57, 86, 20);
		add(textFieldUserName);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 145, 68, 14);
		add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String pass = new String(passwordField01.getPassword());
				String passRepeat = new String(passwordField02.getPassword());
				if(e.getKeyCode() == KeyEvent.VK_ENTER && pass.equals(passRepeat)) {
					submit(pass);
				};
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(passwordField01.getPassword());
				String passRepeat = new String(passwordField02.getPassword());
				if (pass.equals(passRepeat)) {
					submit(pass);
				}else {
					JOptionPane.showMessageDialog(mainController, "Las contraseñas no coinciden");
				}
				
			}
		});
		btnSubmit.setBounds(271, 235, 89, 23);
		add(btnSubmit);
		
		JLabel lblUserName_1 = new JLabel("Email");
		lblUserName_1.setBounds(49, 103, 79, 14);
		add(lblUserName_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(169, 100, 86, 20);
		add(textFieldEmail);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setBounds(49, 191, 104, 14);
		add(lblRepeatPassword);
		
		passwordField01 = new JPasswordField();
		
		passwordField01.setBounds(168, 142, 87, 20);
		add(passwordField01);
		
		passwordField02 = new JPasswordField();
		passwordField02.setBounds(169, 188, 86, 20);
		add(passwordField02);
		passwordField02.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String pass = new String(passwordField01.getPassword());
				String passRepeat = new String(passwordField02.getPassword());
				if(e.getKeyCode() == KeyEvent.VK_ENTER && pass.equals(passRepeat)) {
					submit(pass);
				};
			}
		});
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.goToMainScreen();
			}
		});
		btnReturn.setBounds(39, 235, 89, 23);
		add(btnReturn);
		
	}
	private void submit(String pass) {
		mainController.submitSignUp(textFieldUserName.getText(), pass, textFieldEmail.getText());

	}
}
