package ejercicio01.screens;

import javax.swing.JPanel;

import ejercicio01.components.MyTextField;
import ejercicio01.controller.Ejercicio01Controller;
import javax.swing.JLabel;
import java.awt.Font;


public class Formulario extends JPanel {

	private static final long serialVersionUID = 1L;
	private Ejercicio01Controller controller;
	private MyTextField textField;

	/**
	 * Create the panel.
	 * @param ejercicio01Controller 
	 */
	public Formulario(Ejercicio01Controller ejercicio01Controller) {
		this.controller = ejercicio01Controller;
		setLayout(null);
		
		JLabel lblEdad = new JLabel("Introduce tu edad");
		lblEdad.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEdad.setBounds(33, 142, 110, 14);
		add(lblEdad);
		
		textField = new MyTextField();
		textField.setBounds(153, 139, 35, 20);
		add(textField);
		textField.setColumns(10);
	}
}
