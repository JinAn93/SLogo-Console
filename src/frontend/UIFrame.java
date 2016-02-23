package frontend;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.io.IOException;
/**
 * @author davidyan
 */
@SuppressWarnings("serial")
public class UIFrame extends JFrame{
	private static UIFrame instance;
	private TurtlePanel turtlePanel;
	private JTabbedPane tabbedPane;
	
	private UIFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super("Slogo Team 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateDisplays();
		setVisible(true);
		pack();
	}

	public static UIFrame getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		if(instance == null){
			instance = new UIFrame();
		}
		return instance;
	}
	private void populateDisplays() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		tabbedPane = new JTabbedPane();
		addTab();
		add(tabbedPane);

	}

	public void addTab() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		JPanel newTab = new JPanel();
		turtlePanel = new TurtlePanel();
		newTab.add(turtlePanel);
		newTab.add(new UIConsole());
		newTab.add(new UIPanel());
		tabbedPane.addTab("New Tab", newTab);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
	
	public void closeTab() {
		if(tabbedPane.getTabCount() > 1){
			tabbedPane.remove(tabbedPane.getSelectedComponent());
		}
	}
}
