package fxFrontend;

import javafx.geometry.Insets;
import javafx.scene.Scene;
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
	}
	public Scene getScene(){
		return myScene;
	}

}