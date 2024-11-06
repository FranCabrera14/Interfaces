package screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.MainController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogIn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsername;
	private MainController mainController;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LogIn(MainController mainController) {
		this.mainController = mainController;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(174, 28, 113, 28);
		add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(62, 121, 79, 14);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(62, 162, 68, 14);
		add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(157, 118, 86, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 159, 86, 20);
		add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					mainController.submitLogin(textFieldUsername.getText(),new String( passwordField.getPassword()));
				};
			}
		});
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					mainController.submitLogin(textFieldUsername.getText(),new String( passwordField.getPassword()));
				};
			}
		});
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.submitLogin(textFieldUsername.getText(),new String( passwordField.getPassword()));
				
				
				
			}
		});
		btnSubmit.setBounds(263, 212, 89, 23);
		add(btnSubmit);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					mainController.goToMainScreen();
				};
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.goToMainScreen();
			}
		});
		btnReturn.setBounds(52, 212, 89, 23);
		add(btnReturn);
		
	

	}
}
