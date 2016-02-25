package frontend;
import java.awt.*;
import javax.swing.border.LineBorder;
import frontend.UIConstraints;
import javax.swing.*;

/**
 * @author davidyan
 */
@SuppressWarnings("serial")
public class UIPanel extends JPanel {
	
	private JTextArea turtleStats, variablesList, commandsList;
	
	UIPanel() {
		super(new GridBagLayout());
		this.setBorder(new LineBorder(Color.black));
		turtleStats = new JTextArea(10, 15);
		turtleStats.setEditable(false);

		JScrollPane turtleStatsScrollPane = new JScrollPane(turtleStats);
		add(turtleStatsScrollPane, UIConstraints.getInstance());
		
		commandsList = new JTextArea(10, 15);
		commandsList.setEditable(false);
		commandsList.setMaximumSize(getMaximumSize());
		JScrollPane userCommandsScrollPane = new JScrollPane(commandsList);
		add(userCommandsScrollPane, UIConstraints.getInstance());

		variablesList = new JTextArea(10, 15);
		variablesList.setEditable(false);
		variablesList.setMaximumSize(getMaximumSize());
		JScrollPane variablesScrollPane = new JScrollPane(variablesList);
		
		add(variablesScrollPane, UIConstraints.getInstance());
		
	}
	
	public void paint(Graphics g) {
		turtleStats.setText("Turtle Coordinates: \n");	
		variablesList.setText("Variables: \n" );	
		commandsList.setText("User Commands: \n");
	}


	
	
}

