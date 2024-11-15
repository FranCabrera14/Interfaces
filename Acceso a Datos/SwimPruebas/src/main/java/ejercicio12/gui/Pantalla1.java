package ejercicio12.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pantalla1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private App app;

	/**
	 * Create the panel.
	 */
	public Pantalla1(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblPantalla_1 = new JLabel("Pantalla 1");
		lblPantalla_1.setBounds(158, 33, 115, 23);
		add(lblPantalla_1);
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 27));
		textField.setColumns(10);
		textField.setBounds(70, 114, 306, 44);
		add(textField);
		
		
		
		JButton btnP1 = new JButton("Ir a Pantalla1");
		btnP1.setBounds(25, 217, 115, 23);
		btnP1.setEnabled(false);
		add(btnP1);
		
		JButton btnP2 = new JButton("Ir a Pantalla2");
		btnP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null) {
					app.abrirPantalla2(textField.getText());
				}
			}
		});
		btnP2.setBounds(150, 217, 123, 23);
		add(btnP2);
		
		JButton btnP3 = new JButton("Ir a Pantalla3");
		btnP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null) {
					app.abrirPantalla3(textField.getText());
				}
			}
		});
		btnP3.setBounds(283, 217, 127, 23);
		add(btnP3);

	}	public void setTexto(String texto) {
		
		textField.setText(texto);
		
	}
	

}
