package ejercicio12.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class Bienvenida extends JPanel {
	private App app;
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboPantalla;
	Boolean b;

	@SuppressWarnings("unchecked")
	public Bienvenida(App app) {
		this.app = app;
		setBackground(new Color(255, 204, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("HOLA QUE TAL ");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(44, 33, 161, 42);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				app.selectedCombo(comboPantalla.getSelectedIndex());

			}
		});

		btnNewButton.setBounds(65, 126, 89, 23);
		add(btnNewButton);

		comboPantalla = new JComboBox();
		comboPantalla.setModel(
				new DefaultComboBoxModel(new String[] { "Ir a pantalla1", "Ir a pantalla2", "Ir a pantalla3" }));
		comboPantalla.setToolTipText("Ir a pantalla1 \r\nIr a pantalla2\r\nIr a pantalla3");
		comboPantalla.setBounds(283, 41, 111, 22);
		add(comboPantalla);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Mantener texto");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = chckbxNewCheckBox.isSelected();
			}
		});
		chckbxNewCheckBox.setBackground(new Color(153, 255, 255));
		chckbxNewCheckBox.setBounds(285, 209, 140, 23);
		add(chckbxNewCheckBox);

	}

	public Boolean checkBoxvalue() {

		return b;
	}
}
