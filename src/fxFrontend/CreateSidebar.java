package fxFrontend;

import fxFrontend.Display.ObserveTurtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private Button myHelpButton, myNewWorkspaceButton; 
	private int WIDTH = 200;
	private int HEIGHT = 180;
	private TableView myVariablesTable;
	private TableColumn variableCol, valueCol;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CreateSidebar(){
		
		myConsole = new VBox(20); // spacing = 8
		myTurtleStats = new ScrollPane();
		myTurtleLabel = new Label("Turtle Stats:");
		myTurtleText = new TextArea();
		myTurtleText.setEditable(false);
		createBox(myTurtleLabel, myTurtleStats,myTurtleText);
		
		myUserCommands = new ScrollPane();
		myUserLabel = new Label("User Commands:");
		myUserText = new TextArea();
		myUserText.setEditable(false);
		createBox(myUserLabel, myUserCommands,myUserText);
		
		myVariables = new ScrollPane(); 
		myVariablesLabel = new Label("Variables:");
		myVariablesTable = new TableView();
        variableCol = new TableColumn("Variable");

        valueCol = new TableColumn("Value");
        variableCol.setCellValueFactory(
                new PropertyValueFactory<DisplayObject, String>("variableName")
                );
        valueCol.setCellValueFactory(
                new PropertyValueFactory<DisplayObject, Double>("variableValue")
                );
        myVariablesTable.getColumns().addAll(variableCol, valueCol);

		createTableView(myVariablesLabel, myVariables, myVariablesTable);
		
		myHelpButton = new Button("Help"); 
		myConsole.getChildren().add(myHelpButton);
		myHelpButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Stage myStage = new Stage();
				myStage.setTitle("Help");
				myStage.setWidth(500);
				myStage.setHeight(500);
				//Web stuff
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
				//End web stuff
			}
		});
		
		myNewWorkspaceButton = new Button("New Turtle Screen"); 
		myConsole.getChildren().add(myNewWorkspaceButton);
		myNewWorkspaceButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Stage myNewStage = new Stage();
		    	Display myDisplay = new Display();
		    	ObserveTurtle obTurtle = myDisplay.new ObserveTurtle();
		    	myDisplay.getTurtle().get(0).addObserver(obTurtle);
		    	myDisplay.getTurtle().get(1).addObserver(obTurtle);
		    	myNewStage.setScene(myDisplay.getScene());
		    	myNewStage.show();
			}
			});
		

//		myVariablesLabel = new Label("Variables:");
//		myVariablesTable = new TableView();
//		myVariablesTable.setEditable(false);
//		createTableView(myVariablesLabel, myVariables,myVariablesTable);
	}
	
	private void createBox(Label myLabel, ScrollPane myPane, TextArea myText){
		myConsole.getChildren().add(myLabel);
        myPane.setContent(myText);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(HEIGHT);
        myConsole.getChildren().add(myPane);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createTableView(Label myLabel, ScrollPane myPane, TableView myText){
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
	
	public TableView getTable(){
		return myVariablesTable;
	}
	
	

}