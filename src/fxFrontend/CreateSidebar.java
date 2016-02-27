package fxFrontend;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CreateSidebar {
	private VBox myConsole;
	private ScrollPane myTurtleStats, myUserCommands, myVariables;
	private Label myTurtleLabel, myUserLabel, myVariablesLabel;
	private TextArea myTurtleText, myUserText, myVariablesText;
	private Button myHelpButton; 
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
		
		myHelpButton = new Button("Help"); 
		myConsole.getChildren().add(myHelpButton);
		myHelpButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Stage myStage = new Stage();
				myStage.setTitle("Help");
				myStage.setWidth(500);
				myStage.setHeight(500);
				Scene scene = new Scene(new Group());
				VBox root = new VBox();
				final WebView browser = new WebView();
				final WebEngine webEngine = browser.getEngine();
				Hyperlink hypLink = new Hyperlink("http://www.cs.duke.edu/courses/spring16/compsci308/assign/03_slogo/commands.php");
				webEngine.load("http://www.cs.duke.edu/courses/spring16/compsci308/assign/03_slogo/commands.php");
				root.getChildren().addAll(hypLink, browser);
				scene.setRoot(root);
				myStage.setScene(scene);
				myStage.show();
			}
		});
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