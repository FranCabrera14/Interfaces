package pakaje1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CambioPantalla {

	private JFrame frame;
	private JPanel login;
	private JPanel welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioPantalla window = new CambioPantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CambioPantalla() {
		login = new PantallaLogin(this);
		welcome = new PantallaBienvenida(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(login);
	}
	
	public void abrirBienvenida() {
		frame.setContentPane(welcome);
		frame.revalidate();
	}
	public void abrirLogin() {
		frame.setContentPane(login);
		frame.revalidate();
	}
}
