package frontend;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JTextArea;
/**
 * @author davidyan
 */
@SuppressWarnings("serial")
public class TurtlePanel extends Component {
	protected JTextArea history;
	protected JTextArea input, console;
	public static final Dimension SCREEN_DIMENSION = new Dimension(500, 500);
	Graphics2D useEngine;

	public TurtlePanel() {
		super();
	}

	public void paint(Graphics g) {
		useEngine = (Graphics2D) g;
		useEngine.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawBorder();
	}

	public Dimension getPreferredSize() {
		return SCREEN_DIMENSION;
	}
	void drawBorder() {
		useEngine.draw3DRect(0, 0, SCREEN_DIMENSION.width - 1,
				SCREEN_DIMENSION.height - 1, true);
	}
}