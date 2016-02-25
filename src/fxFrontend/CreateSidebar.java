package fxFrontend;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class CreateSidebar {
	private VBox myConsole;
	private ScrollPane myTurtleStats, myUserCommands, myVariables;
	private Label myTurtleLabel, myUserLabel, myVariablesLabel;
	private int WIDTH = 200;
	private int HEIGHT = 180;
	
	public CreateSidebar(){
		
		myConsole = new VBox(20); // spacing = 8
		myTurtleStats = new ScrollPane();
		myTurtleLabel = new Label("Turtle Stats:");
		createBox(myTurtleLabel, myTurtleStats);
		
		myUserCommands = new ScrollPane();
		myUserLabel = new Label("User Commands:");
		createBox(myUserLabel, myUserCommands);
		
		myVariables = new ScrollPane();
		myVariablesLabel = new Label("Variables:");
		createBox(myVariablesLabel, myVariables);
        		
	}
	
	private void createBox(Label myLabel, ScrollPane myPane){
		TextArea textArea = new TextArea();
		myConsole.getChildren().add(myLabel);
        myPane.setContent(textArea);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(HEIGHT);
        myConsole.getChildren().add(myPane);
	}
	
	public VBox getBox(){
		return myConsole;
	}

}
