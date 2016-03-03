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
	
	public CreatePenColorMenu(GraphicsContext graphics){
		gc = graphics; 
		myPenMenu = new Menu("Pen Color"); 
//		getPenColors();
//		myPenMenu.getItems().addAll(myPenColors);
		MenuItem item = new MenuItem("Change color");
		item.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				Stage colorStage = new Stage();
				colorStage.setTitle("Color palette");
				Scene scene = new Scene(new HBox(20), 400, 100);
				HBox box = (HBox) scene.getRoot();
				box.setPadding(new Insets(5, 5, 5, 5));          

				final ColorPicker colorPicker = new ColorPicker();
				colorPicker.setValue(Color.CORAL);
				colorPicker.setOnAction(new EventHandler() {
					public void handle(Event t) {
						gc.setStroke(colorPicker.getValue());               
					}
				});
				box.getChildren().addAll(colorPicker); 
				colorStage.setScene(scene);
				colorStage.show();
			}
		});
		myPenMenu.getItems().addAll(item); 
		
	}
	
//	private void getPenColors(){
//		myPenColors = new ArrayList<MenuItem>(); 
//		for(String color: myColors){
//			MenuItem item = new MenuItem(color);
//			item.setOnAction(new EventHandler<ActionEvent>() {
//				public void handle(ActionEvent e){
//					gc.setStroke(Color.valueOf(color));
//				}
//			});
//			myPenColors.add(item);
//		}
//	}
//	
	public Menu getPenMenu(){
		return myPenMenu;
	}
	
//	public CreatePenColorMenu(GraphicsContext graphics){
//		gc = graphics; 
//		HBox box = new HBox(); 
//		myPenMenu = new Menu("Change Pen Color");
//		final ColorPicker colorPicker = new ColorPicker(); 
//		colorPicker.setValue(Color.BLACK);
//		box.getChildren().add(colorPicker); 
//		MenuItem item = new MenuItem();
//		myPenMenu.getItems().add();
//		
//	}
}
