package frontend;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * @author davidyan
 */
@SuppressWarnings("serial")
public class ChangeDisplayColor extends JPanel implements ChangeListener {

	protected JColorChooser colorChooser;

	public ChangeDisplayColor() {
		super(new BorderLayout());

		colorChooser = new JColorChooser(Color.black);
		colorChooser.getSelectionModel().addChangeListener(this);
		colorChooser.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
		
		add(colorChooser, BorderLayout.PAGE_END);
	}

	public void stateChanged(ChangeEvent e) {
		//get color back from colorChooser
	}
}