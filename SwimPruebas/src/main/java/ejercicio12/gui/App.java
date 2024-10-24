package ejercicio12.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frame;
	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;
	private Bienvenida bienvenida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		bienvenida = new Bienvenida(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 51, 204));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setContentPane(bienvenida);

	}

	public void abrirPantalla2(String texto, Boolean checkbox) {
		if (!checkbox) {
			frame.setContentPane(pantalla2);
			frame.revalidate();
		} else {
			frame.setContentPane(pantalla2);
			pantalla2.setTexto(texto);
			frame.revalidate();
		}

	}

	public void abrirPantalla3(String texto, Boolean checkbox) {
		if (!checkbox) {
			frame.setContentPane(pantalla3);
			frame.revalidate();
		} else {
			frame.setContentPane(pantalla3);
			pantalla3.setTexto(texto);
			frame.revalidate();
		}
	}

	public void abrirPantalla1(String texto, Boolean checkbox) {
		if (!checkbox) {
			frame.setContentPane(pantalla1);
			frame.revalidate();
		} else {
			frame.setContentPane(pantalla1);
			pantalla1.setTexto(texto);
			frame.revalidate();
		}

	}

	public void selectedCombo(Integer i) {
	
		if (i == 0) {
			abrirPantalla1("callate natalia");
		} else if (i == 1) {
			abrirPantalla2("callate natalia");
		} else {
			abrirPantalla3("callate natalia");
		}

	}
}
