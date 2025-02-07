package components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class JMyPasswordField extends JPasswordField implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5212094602358324912L;
	private Integer maxLength;
	public JMyPasswordField() {
		super();
		addKeyListener(this);
		
	}

	public JMyPasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		addKeyListener(this);
	}

	public JMyPasswordField(int columns) {
		super(columns);
		addKeyListener(this);
	}

	public JMyPasswordField(String text, int columns) {
		super(text, columns);
		addKeyListener(this);
	}

	public JMyPasswordField(String text) {
		super(text);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		if (getPassword().length > maxLength) {
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
