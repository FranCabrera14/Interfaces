package pakaje1.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private CambioPantalla  app;

	/**
	 * Create the panel.
	 */
	public PantallaLogin(CambioPantalla app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Sylfaen", Font.BOLD, 24));
		lblLogin.setBounds(121, 125, 71, 56);
		add(lblLogin);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirBienvenida();
			}
		});
		btnEntrar.setBounds(114, 214, 89, 23);
		add(btnEntrar);
		
	}
	
	
}
