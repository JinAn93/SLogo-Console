package frontend;

import java.awt.GridBagConstraints;
/**
 * @author davidyan
 */
@SuppressWarnings("serial")
public class UIConstraints extends GridBagConstraints {
	private static UIConstraints instance;
	private UIConstraints(){
		super();
		gridwidth = GridBagConstraints.REMAINDER;
		fill = GridBagConstraints.BOTH;
		weightx = 1.0;
		weighty = 1.0;
	}
	public static UIConstraints getInstance(){
		if(instance == null){
			instance = new UIConstraints();
		}
		return instance;
	}
}
