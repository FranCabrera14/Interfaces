package ejercicio01.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class MyTextField extends JTextField implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 412345804028442399L;
	private Integer num;
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (this.getText().isEmpty()) {
			
				this.setText("1");
			}else {
				
				num = Integer.parseInt(this.getText()) + 1 ;
				
				
				this.setText(num.toString());
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (this.getText().equals("1")) {
				this.setText("1");
			}else if (this.getText().isEmpty()){
				
				this.setText("1");
				
			}else {
				num = Integer.parseInt(this.getText()) - 1;
				
				this.setText(num.toString());
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public MyTextField() {
		addKeyListener(this);
	}

	public MyTextField(Document doc, String text, int columns) {
		addKeyListener(this);
	}

	public MyTextField(int columns) {
		addKeyListener(this);
	}

	public MyTextField(String text, int columns) {
		addKeyListener(this);
	}

	public MyTextField(String text) {
		addKeyListener(this);
	}
	
	

}
