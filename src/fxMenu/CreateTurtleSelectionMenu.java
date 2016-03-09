package fxMenu;

import Turtle.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import java.util.*;

public class CreateTurtleSelectionMenu {
	private List<SingleTurtle> myTurtle;
	private String[] imgList = {"koopa","Boat","Car","FlatTurtle","MonopolyMan","turtle","Plane"};
	private Menu myImageMenu;
	private ArrayList<MenuItem> myImageItems;
	
	public CreateTurtleSelectionMenu(List<SingleTurtle> useTurtle){
		myTurtle = useTurtle;
		myImageMenu = new Menu("Change Turtle Images");
		createItems();
		myImageMenu.getItems().addAll(myImageItems);
	}
	
	public void createItems(){
		myImageItems = new ArrayList<MenuItem>();
		for(String astring: imgList){
			MenuItem anItem = new MenuItem(astring);
			anItem.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e) {
	            	String dir = "/resources/"+astring+".png";
	            	for(Turtle aTurtle: myTurtle)
	            	    aTurtle.setTurtleImage(dir);
	            }
	        });
	        myImageItems.add(anItem);
		}
	}
	
	public Menu getImageMenu(){
		return myImageMenu;
	}
	
}
