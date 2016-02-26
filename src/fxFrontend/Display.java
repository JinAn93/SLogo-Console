package fxFrontend;

import Main.Output;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class Display {
	private BorderPane myBorder;
	private Scene myScene;
	private VBox leftBox, centerBox, consoleBox;
	private CreateSidebar mySidebar = new CreateSidebar();
	private CreateTurtleScreen myScreen = new CreateTurtleScreen();
	private CreateConsole myConsole = new CreateConsole();
	private Button myButton;
	private TextArea turtleBox;
	private TextArea historyBox; 
	private Output backendOutput = new Output("Test");
//	private ArrayList<String> commandHistory = new ArrayList<String>();
	private StringBuilder commandHistory = new StringBuilder(); 
	
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
        historyBox = myConsole.getHistoryTextArea();
        myButton = myScreen.getButton();
        updateDisplay(); 

	}
	
	public void updateDisplay(){
		myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	commandHistory.append(backendOutput.getCommand() + "\n");
            	historyBox.setText(commandHistory.toString());
            	turtleBox.appendText(backendOutput.getCommand() + "\n");
            }
        });
	}
	
	public Scene getScene(){
		return myScene;
	}
	
//	public List getCommandHistory(){
//		return commandHistory; 
//	}

}