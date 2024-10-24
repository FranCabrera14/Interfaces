package ejercicio12.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;
	private JTextField textField;
	

	/**
	 * Create the panel.
	 */
	public Pantalla2(App app) {
		this.app = app;
		setLayout(null);
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 27));
		textField.setColumns(10);
		textField.setBounds(70, 114, 306, 44);
		add(textField);
		
		
		
		JButton btnP1 = new JButton("Ir a Pantalla1");
		btnP1.setBounds(31, 206, 115, 23);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null) {
					app.abrirPantalla1(textField.getText());
				}else {
					app.abrirPantalla1("hola");
				}
			}
		});
		add(btnP1);
		
		JButton btnP2 = new JButton("Ir a Pantalla2");
		btnP2.setEnabled(false);
		btnP2.setBounds(156, 206, 123, 23);
		add(btnP2);
		
		JButton btnP3 = new JButton("Ir a Pantalla3");
		btnP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					app.abrirPantalla3(textField.getText());
			
			
			}
		});
		btnP3.setBounds(289, 206, 127, 23);
		add(btnP3);
		
		JLabel lblPantalla = new JLabel("Pantalla 2");
		lblPantalla.setBounds(164, 22, 115, 23);
		add(lblPantalla);
		
		
		
		

	}
	public void setTexto(String texto) {
		
		textField.setText(texto);
		
	}


}
