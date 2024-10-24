package pakaje1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ejercicio02 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio02 window = new Ejercicio02();
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
	public Ejercicio02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 2, 0, 3));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNombre = new JLabel("Nombre\r\n");
		lblNombre.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNombre.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblNombre);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDNI = new JLabel("DNI\r\n");
		panel_2.add(lblDNI);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_4);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento\r\n");
		panel_4.add(lblFechaNacimiento);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		frame.getContentPane().add(panel_5);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(2);
		
		JLabel lblBarra01 = new JLabel("/\r\n");
		panel_5.add(lblBarra01);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(2);
		
		JLabel lblBarra02 = new JLabel("/");
		panel_5.add(lblBarra02);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(2);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_6);
		
		JButton btnAceptar = new JButton("Aceptar\r\n");
		panel_6.add(btnAceptar);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_7);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		panel_7.add(btnCancelar);
		
		frame.pack();
	}
}
