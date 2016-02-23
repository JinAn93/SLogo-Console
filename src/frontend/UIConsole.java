package frontend;

import java.awt.Dimension;
import frontend.UIConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.*;

/**
 * @author davidyan
 */
@SuppressWarnings("serial")
public class UIConsole extends JPanel {
	private JButton runButton;
	protected JTextArea inputText, consoleText, userHistory;
	private ArrayList<String> history = new ArrayList<String>(); 
	
	public UIConsole() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super(new GridBagLayout());
		addHistory();
		addCodeInput();
		addRunButton();
		addConsoleOutput();
		setPreferredSize(new Dimension(259, 521));
	}
	
	private void addRunButton() {
		runButton = new JButton("Run");
		add(runButton, UIConstraints.getInstance());
		runButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				history.add(inputText.getText());
				updateHistory(history);
			}
		});
	}
	
	private void updateHistory(List<String> codeHistory){
		String output = "";  
		for (String s: codeHistory){
			output += s + "\n";
		}
		consoleText.setText(output);
	}
	
	
	private void addConsoleOutput() {
		consoleText = new JTextArea(5, 18);
		consoleText.setEditable(false);
		
		JScrollPane consoleScrollPane = new JScrollPane(consoleText);
		add(consoleScrollPane, UIConstraints.getInstance());
	}
	
	private void addCodeInput() {
		inputText = new JTextArea(5, 18);
		inputText.setText("Code!");
		
		JScrollPane inputScrollPane = new JScrollPane(inputText);
		add(inputScrollPane, UIConstraints.getInstance());
	}
	
	private void addHistory(){
		userHistory = new JTextArea(20, 20);
		userHistory.setEditable(false);
		JScrollPane userHistoryScrollPane = new JScrollPane(userHistory);
		add(userHistoryScrollPane, UIConstraints.getInstance());
	}
}