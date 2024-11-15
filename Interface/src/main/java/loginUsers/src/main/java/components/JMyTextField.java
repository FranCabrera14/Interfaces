package components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class JMyTextField extends JTextField implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3557506499672489894L;
	private Integer maxLength;
	public JMyTextField() {
		super();
		addKeyListener(this);
	}

	public JMyTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		addKeyListener(this);
	}

	public JMyTextField(int columns) {
		super(columns);
		addKeyListener(this);
	}

	public JMyTextField(String text, int columns) {
		super(text, columns);
		addKeyListener(this);
	}

	public JMyTextField(String text) {
		super(text);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(getText().length() > maxLength) {
			e.consume();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_V && e.isControlDown()) {
			e.consume();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

}
