package pakaje1.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaBienvenida extends JPanel {

	private static final long serialVersionUID = 1L;
	private CambioPantalla app;

	/**
	 * Create the panel.
	 */
	public PantallaBienvenida(CambioPantalla app) {
		this.app = app;
		setLayout(null);
		
		JButton btnSalir = new JButton("Vete de aquí");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirLogin();
			}
		});
		btnSalir.setBounds(136, 131, 121, 23);
		add(btnSalir);
		JLabel lblHola = new JLabel("HOLAAAA");
		lblHola.setBounds(152, 80, 48, 14);
		add(lblHola);

	}

}
