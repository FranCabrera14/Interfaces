package pakaje1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Ejercicio05 {

	private JFrame frame;
	private Integer suma;
	private JTextField textoSumar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio05 window = new Ejercicio05();
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
	public Ejercicio05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		textoSumar = new JTextField();

		ActionListener accionSumar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botoncito = (JButton) e.getSource();

				if (textoSumar.getText().isEmpty()) {
					suma = 1;
				}else if (textoSumar.getText().equals("32")) {
					botoncito.setText("Viva el nanoooooo");
					suma = 33;					
				}else if (textoSumar.getText().equals("33")) {
					frame.dispose();
				} else {
					try {
						Integer numFormateao = Integer.parseInt(textoSumar.getText());
						textoSumar.setText(Integer.toString(numFormateao + 1));
						suma = numFormateao + 1;
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(frame, "Así el nano nunca conseguirá la 33");
						textoSumar.setText("");
					}
				}

				
				textoSumar.setText(suma.toString());

			}
		};

		frame.getContentPane().add(textoSumar);

		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(accionSumar);
		frame.getContentPane().add(btnSumar);

		frame.getContentPane().add(textoSumar);
		textoSumar.setColumns(10);
	}

}
