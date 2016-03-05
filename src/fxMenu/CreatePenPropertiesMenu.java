package fxMenu;

import Main.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class CreatePenPropertiesMenu {
	private Turtle myTurtle;
	private Menu myPenUpMenu;
	
	public CreatePenPropertiesMenu(Turtle turt){
		myTurtle = turt;
		myPenUpMenu = new Menu("Set Pen Up/Down");
		MenuItem setPenDown = new MenuItem("Set Pen Down");
		MenuItem setPenUp = new MenuItem("Set Pen Up");
		MenuItem setPenWidth = new MenuItem("Set Pen Width");
		
		setPenDown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				myTurtle.setPen(1);
			}
		});
		
		setPenUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				myTurtle.setPen(0);
			}
		});
		
		setPenWidth.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				myTurtle.setPenWidth(8.0);
			}
		});
		
		myPenUpMenu.getItems().add(setPenDown);
		myPenUpMenu.getItems().add(setPenUp);
		myPenUpMenu.getItems().add(setPenWidth);
	}
	
	public Menu getPenUpMenu(){
		return myPenUpMenu;
	}

}