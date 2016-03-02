package fxMenu;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class CreatePenColorMenu {
	private Menu myPenMenu;
	private GraphicsContext gc; 
	private ArrayList<MenuItem> myPenColors; 
	private String[] myColors = {"RED","BLUE","GREEN","YELLOW","PINK"};
	
	public CreatePenColorMenu(GraphicsContext graphics){
		gc = graphics; 
		myPenMenu = new Menu("Change Pen Color"); 
		getPenColors();
		myPenMenu.getItems().addAll(myPenColors);
	}
	
	private void getPenColors(){
		myPenColors = new ArrayList<MenuItem>(); 
		for(String color: myColors){
			MenuItem item = new MenuItem(color);
			item.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e){
					gc.setStroke(Color.valueOf(color));
				}
			});
			myPenColors.add(item);
		}
	}
	
	public Menu getPenMenu(){
		return myPenMenu;
	}
}
