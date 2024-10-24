package ejercicio12.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private App app;

	/**
	 * Create the panel.
	 */
	public Pantalla3(App app) {
		this.app = app;
		setLayout(null);
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 27));
		textField.setColumns(10);
		textField.setBounds(70, 114, 306, 44);
		add(textField);
		
		
		JButton btnP1 = new JButton("Ir a Pantalla1");
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null) {
					app.abrirPantalla1(textField.getText());
				}else {
					app.abrirPantalla1("hola");
				}
			}
		});
		btnP1.setBounds(28, 216, 115, 23);
		add(btnP1);
		
		JButton btnP2 = new JButton("Ir a Pantalla2");
		btnP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null) {
					app.abrirPantalla2(textField.getText());
				}else {
					app.abrirPantalla2("hola");
				}
			}
		});
		btnP2.setBounds(153, 216, 123, 23);
		add(btnP2);
		
		JButton btnP3 = new JButton("Ir a Pantalla3");
		btnP3.setBounds(286, 216, 127, 23);
		btnP3.setEnabled(false);
		add(btnP3);
		
		JLabel lblNewLabel = new JLabel("Pantalla 3");
		lblNewLabel.setBounds(173, 25, 115, 23);
		add(lblNewLabel);
		
	
		

	}	public void setTexto(String texto) {
		
		textField.setText(texto);
		
	}

}
