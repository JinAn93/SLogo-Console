package fxMenu;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class CreateBackgroundColorMenu {
	private Menu myColorMenu;
	private GraphicsContext toChangeGraphics;
	private int width = 600;
	private int height = 600;
	private ArrayList<MenuItem> myColorItems;
	private String[] myColors = {"RED","BLUE","GREEN","YELLOW","PINK"};
	
	public CreateBackgroundColorMenu(GraphicsContext myChange, GraphicsContext myLineGraphics){
        toChangeGraphics = myChange;
		myColorMenu = new Menu("Change Background Color");
		getColors();
		myColorMenu.getItems().addAll(myColorItems); 
		MenuItem myClearItem = new MenuItem("Clear the Screen");
        myClearItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	myChange.clearRect(0, 0, width, height);
            	myChange.fillRect(0, 0, width, height);
            	myLineGraphics.clearRect(0, 0, width, height);
            	myLineGraphics.fillRect(0, 0, width, height);
            }
        });
        myColorMenu.getItems().add(myClearItem);
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
