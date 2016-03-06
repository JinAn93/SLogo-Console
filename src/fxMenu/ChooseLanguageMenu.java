package fxMenu;
import java.util.*;
import Main.InputObject;
import Main.MainBackEnd;
import fxFrontend.Display;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
public class ChooseLanguageMenu {
	
	private String[] myLanguages = {"Chinese","English","French","German","Italian",
			"Portuguese","Russian","Spanish","Syntax"};
	private Menu myLanguageMenu;
	private ArrayList<MenuItem> myLanguageOptions;
	private String myLang;
	private InputObject myInput;
	private Display disp; 
	private ResourceBundle myResource;
	
	public ChooseLanguageMenu(Display useDisplay){
		myLanguageMenu = new Menu("Choose Language");
		disp = useDisplay;
		getLanguages();
		myLanguageMenu.getItems().addAll(myLanguageOptions); 
	}
	private void getLanguages(){
		myLanguageOptions = new ArrayList<MenuItem>();
		for(String aString: myLanguages){
			MenuItem anItem = new MenuItem(aString);
	        anItem.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e) {
	            	myResource = ResourceBundle.getBundle("languagefiles/" + aString);
	            	disp.setLanguage(myResource);
	            }
	        });
	        myLanguageOptions.add(anItem);
		}
	}
	public Menu getMenu(){
		return myLanguageMenu;
	}

}
