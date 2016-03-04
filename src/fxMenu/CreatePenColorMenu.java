package fxMenu;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox; 

public class CreatePenColorMenu {
	private Menu myPenMenu;
	private GraphicsContext gc; 
	private ArrayList<MenuItem> myPenColors; 
	private String[] myColors = {"RED","BLUE","GREEN","YELLOW","PINK"};
	private ColorPicker colorPicker; 
	
	public CreatePenColorMenu(GraphicsContext graphics){
		gc = graphics; 
		myPenMenu = new Menu("Pen Color"); 
		MenuItem item = new MenuItem("Change color");
		item.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				Stage colorStage = new Stage();
				colorStage.setTitle("Pen color palette");
				Scene scene = new Scene(new HBox(20), 200, 50);
				HBox box = (HBox) scene.getRoot();
				box.setPadding(new Insets(5, 5, 5, 5));          
				createPalette();
				box.getChildren().addAll(colorPicker); 
				colorStage.setScene(scene);
				colorStage.show();
			}
		});
		myPenMenu.getItems().addAll(item); 
	}
	
	public void createPalette(){
		colorPicker = new ColorPicker();
		colorPicker.setValue(Color.CORAL);
		colorPicker.setOnAction(new EventHandler() {
			public void handle(Event t) {
				gc.setStroke(colorPicker.getValue());               
			}
		});
	}
	
	public Menu getPenMenu(){
		return myPenMenu;
	}
}
