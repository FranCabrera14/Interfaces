package screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;

import controller.MainController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangePass extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField CurrentpasswordField;
	private JPasswordField NewPasswordFiel;
	private JPasswordField RepeatPasswordField;
	private MainController mainController;

	/**
	 * Create the panel.
	 */
	public ChangePass(MainController mainController) {
		this.mainController = mainController;
		setLayout(null);
		
		JLabel lblChangePass = new JLabel("Change your Password");
		lblChangePass.setFont(new Font("Verdana", Font.BOLD, 20));
		lblChangePass.setBounds(147, 11, 113, 28);
		add(lblChangePass);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(53, 138, 85, 14);
		add(lblNewPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setBounds(53, 184, 104, 14);
		add(lblRepeatPassword);
		
		JLabel lblCurrent = new JLabel("Current Password");
		lblCurrent.setBounds(53, 88, 104, 14);
		add(lblCurrent);
		
		CurrentpasswordField = new JPasswordField();
		CurrentpasswordField.setBounds(187, 85, 87, 20);
		add(CurrentpasswordField);
		
		NewPasswordFiel = new JPasswordField();
		NewPasswordFiel.setBounds(187, 135, 87, 20);
		add(NewPasswordFiel);
		
		RepeatPasswordField = new JPasswordField();
		RepeatPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					submit();
				}
			}
		});
		RepeatPasswordField.setBounds(187, 181, 87, 20);
		add(RepeatPasswordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					submit();
				};
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
				
			
			}
		});
		btnSubmit.setBounds(256, 246, 89, 23);
		add(btnSubmit);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					mainController.goToProfileScreen();
				};
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.goToProfileScreen();
			}
		});
		btnReturn.setBounds(82, 246, 89, 23);
		add(btnReturn);

	}
	
	private void submit() {
		mainController.submitChangePass(new String (CurrentpasswordField.getPassword()), new String (NewPasswordFiel.getPassword()));

	}

}
