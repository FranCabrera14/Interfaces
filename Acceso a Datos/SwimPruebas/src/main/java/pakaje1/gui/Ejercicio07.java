package pakaje1.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Ejercicio07 {

	private JFrame frame;
	private JTextField tf01;
	private JTextField tf02;
	private JTextField tf03;
	private JTextField tf04;
	private Color selectedColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio07 window = new Ejercicio07();
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
	public Ejercicio07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		JComboBox<String> comboBox = new JComboBox<>();
		JRadioButton radioPSOE = new JRadioButton("RojoPSOE");
		JRadioButton radioPP = new JRadioButton("AzulPP");
		JRadioButton radioUPYD = new JRadioButton("RosaUPYD");
		JRadioButton radioVox = new JRadioButton("VerdeVOX");
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(radioPSOE);
		grupo.add(radioPP);
		grupo.add(radioUPYD);
		grupo.add(radioVox);
		

		tf01 = new JTextField();

		tf01.addKeyListener(new KeyAdapter() {
			// evento text Field 1 si entra en el textfield hacia arriba da la vuelta y
			// regresa al último, si va hacia abajo va al segundo
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					tf02.grabFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					tf04.grabFocus();
				}
			}
		});
		// Métodos para cuando entremos en el textField se ponga de un color y si
		// salimos se quita
		tf01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf01.setBackground(selectedColor);
			}

			@Override
			public void focusLost(FocusEvent e) {
				tf01.setBackground(null);
			}
		});

		panel_1.add(tf01);
		tf01.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		tf02 = new JTextField();

		tf02.addKeyListener(new KeyAdapter() {
			// evento text Field 2 si se presiona arriba vuelve al primer textField, si
			// pulsa abajo o ENTER va al textField 3
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					tf03.grabFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					tf01.grabFocus();
				}
			}
		});
		// Métodos para cuando entremos en el textField se ponga de un color y si
		// salimos se quita
		tf02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf02.setBackground(selectedColor);
			}

			@Override
			public void focusLost(FocusEvent e) {
				tf02.setBackground(null);
			}
		});
		panel_2.add(tf02);
		tf02.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		tf03 = new JTextField();

		tf03.addKeyListener(new KeyAdapter() {
			// evento text Field 3 si se presiona arriba vuelve al segundo textField, si
			// pulsa abajo o ENTER va al textField 4
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					tf04.grabFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					tf02.grabFocus();
				}
			}
		});
		panel_3.add(tf03);
		tf03.setColumns(10);
		// Métodos para cuando entremos en el textField se ponga de un color y si
		// salimos se quita
		tf03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf03.setBackground(selectedColor);
			}

			@Override
			public void focusLost(FocusEvent e) {
				tf03.setBackground(null);
			}
		});

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		tf04 = new JTextField();

		tf04.addKeyListener(new KeyAdapter() {
			// evento text Field 4 si entra en el textfield hacia abajo da la vuelta y
			// regresa al primero, si va hacia arriba vuelve al tercero
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					tf01.grabFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					tf03.grabFocus();
				}
			}
		});
		// Métodos para cuando entremos en el textField se ponga de un color y si
		// salimos se quita
		tf04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf04.setBackground(selectedColor);
			}

			@Override
			public void focusLost(FocusEvent e) {
				tf04.setBackground(null);
			}
		});
		panel_4.add(tf04);
		tf04.setColumns(10);

		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>(
				new String[] { "RojoPSOE", "AzulPP", "RosaUPYD", "VerdeVOX" });

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		panel_7.setLayout(new GridLayout(4, 1, 0, 0));

		radioPSOE.setBackground(new Color(255, 0, 0));
		radioPSOE.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(radioPSOE);
		
	

		radioPP.setForeground(new Color(255, 255, 255));
		radioPP.setBackground(new Color(0, 0, 255));
		radioPP.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(radioPP);

		radioUPYD.setBackground(Color.MAGENTA);
		radioUPYD.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(radioUPYD);

		radioVox.setBackground(Color.GREEN);
		radioVox.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(radioVox);
		
		radioPSOE.addActionListener(e -> {
			comboBox.setSelectedItem("RojoPSOE");
		});
		
		radioPP.addActionListener(e -> {
			comboBox.setSelectedItem("AzulPP");
		});
		
		radioUPYD.addActionListener(e -> {
			comboBox.setSelectedItem("RosaUPYD");
		});
		
		radioVox.addActionListener(e -> {
			comboBox.setSelectedItem("VerdeVOX");
		});

		panel_6.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = (String) comboBox.getSelectedItem();

				switch (color) {

				case "RojoPSOE":
					selectedColor = Color.RED;
					radioPSOE.setSelected(true);
					break;
				case "AzulPP":
					selectedColor = Color.BLUE;
					radioPP.setSelected(true);
					break;
				case "RosaUPYD":
					selectedColor = Color.MAGENTA;
					radioUPYD.setSelected(true);
					break;
				case "VerdeVOX":
					selectedColor = Color.GREEN;
					radioVox.setSelected(true);
				default:
					break;
				}
			}
		});
		comboBox.setModel(modelo);
		
//		new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (rdbtnRadioButton_01.getActionListeners().)
//				
//			}
//		};

	}

}
