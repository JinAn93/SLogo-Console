package fxFrontend;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Display {
	private BorderPane myBorder;
	private Scene myScene;
	private VBox leftBox, centerBox, consoleBox;
	private CreateSidebar mySidebar = new CreateSidebar();
	private CreateTurtleScreen myScreen = new CreateTurtleScreen();
	private CreateConsole myConsole = new CreateConsole();
	private Button myButton;
	private TextArea turtleBox;
	
	public Display(){
		myBorder = new BorderPane();
		displayScreen();
        myBorder.setPadding(new Insets(10, 20, 10, 20));
        myScene = new Scene(myBorder, 1100, 800);
	}
	
	public void displayScreen(){
		leftBox = mySidebar.getBox();
		centerBox = myScreen.getScreen();
		consoleBox = myConsole.getConsole();
        myBorder.setLeft(leftBox);
        myBorder.setCenter(centerBox);
        myBorder.setRight(consoleBox);
        turtleBox = mySidebar.getArea();
        
        myButton = myScreen.getButton();
        
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	turtleBox.appendText("HI\n");
            }
        });
        

	}
	public Scene getScene(){
		return myScene;
	}

}