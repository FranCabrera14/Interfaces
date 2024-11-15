package pakaje1.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ejercicio03 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio03 window = new Ejercicio03();
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
	public Ejercicio03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 0, 0, 0));
		JLabel label1 = new JLabel("Pulsa en los botoncitos");
		ActionListener accion1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botoncito = (JButton) e.getSource();
				label1.setText("Has pulsado el botón" + botoncito.getText());
				botoncito.setText(botoncito.getText() + "!");
				
			

			}
		};
		
		MouseListener ratonCambiaColor = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				JButton botoncito3 = (JButton) e.getSource();
				botoncito3.setBackground(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				JButton botoncito2 = (JButton) e.getSource();
				botoncito2.setBackground(Color.pink);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		JButton boton1 = new JButton("1");
		frame.getContentPane().add(boton1);
		boton1.addActionListener(accion1);
		boton1.addMouseListener(ratonCambiaColor);
		
		JButton boton2 = new JButton("2");
		frame.getContentPane().add(boton2);
		boton2.addActionListener(accion1);
		boton2.addMouseListener(ratonCambiaColor);
		
		JButton boton3 = new JButton("3");
		boton3.addActionListener(accion1);
		boton3.addMouseListener(ratonCambiaColor);
		frame.getContentPane().add(boton3);

		frame.getContentPane().add(label1);

	}

}
