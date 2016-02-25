package fxFrontend;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class CreateSidebar {
	private VBox myConsole;
	private ScrollPane myTurtleStats, myUserCommands, myVariables;
	private Label myTurtleLabel, myUserLabel, myVariablesLabel;
	private TextArea myTurtleText, myUserText, myVariablesText;
	private int WIDTH = 200;
	private int HEIGHT = 180;
	
	public CreateSidebar(){
		
		myConsole = new VBox(20); // spacing = 8
		myTurtleStats = new ScrollPane();
		myTurtleLabel = new Label("Turtle Stats:");
		myTurtleText = new TextArea();
		createBox(myTurtleLabel, myTurtleStats,myTurtleText);
		
		myUserCommands = new ScrollPane();
		myUserLabel = new Label("User Commands:");
		myUserText = new TextArea();
		createBox(myUserLabel, myUserCommands,myUserText);
		
		myVariables = new ScrollPane();
		myVariablesLabel = new Label("Variables:");
		myVariablesText = new TextArea();
		createBox(myVariablesLabel, myVariables,myVariablesText);
        		
	}
	
	private void createBox(Label myLabel, ScrollPane myPane, TextArea myText){
		myConsole.getChildren().add(myLabel);
        myPane.setContent(myText);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(HEIGHT);
        myConsole.getChildren().add(myPane);
	}
	
	public VBox getBox(){
		return myConsole;
	}
	
	public TextArea getArea(){
		return myTurtleText;
	}
	

}