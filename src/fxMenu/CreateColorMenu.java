package fxMenu;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class CreateColorMenu {
	private Menu myColorMenu;
	private GraphicsContext toChangeGraphics;
	private int width,height;
	private ArrayList<MenuItem> myColorItems;
	private String[] myColors = {"RED","BLUE","GREEN","YELLOW","PINK"};
	
	public CreateColorMenu(GraphicsContext myChange, int w, int h){
        toChangeGraphics = myChange;
        width = w;
        height = h;
		myColorMenu = new Menu("Change Background Color");
		getColors();
		myColorMenu.getItems().addAll(myColorItems);        
	}
	
	private void getColors(){
		myColorItems = new ArrayList<MenuItem>();
		for(String aString: myColors){
			MenuItem anItem = new MenuItem(aString);
	        anItem.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e) {
	            	toChangeGraphics.setFill(Color.valueOf(aString));
	            	toChangeGraphics.fillRect(0,0,width,height);
	            }
	        });
	        myColorItems.add(anItem);
		}
	}
	
	
	public Menu getColorMenu(){
		return myColorMenu;
	}
	
}
