package fxFrontend;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class CreateConsole {
	private VBox myConsolePane;
	private ScrollPane myHistory, myConsole;
	private Label myConsoleLabel, myHistoryLabel;
	private TextArea myHistoryText, myConsoleText;
	private int WIDTH = 200;
	private int HEIGHT = 150;
	
	public CreateConsole(){
		myConsolePane = new VBox(20); // spacing = 8
		myConsolePane.setPadding(new Insets(0, 20, 10, 20)); 
		
		myHistory = new ScrollPane();
		myHistoryLabel = new Label("History:");
		myHistoryText = new TextArea();
		createBox(myHistoryLabel, myHistory,myHistoryText, 350+HEIGHT);
		
		myConsole = new ScrollPane();
		myConsoleLabel = new Label("Console:");
		myConsoleText = new TextArea();
		createBox(myConsoleLabel, myConsole, myConsoleText, HEIGHT);

	}
	
	private void createBox(Label myLabel, ScrollPane myPane, TextArea myText, int height){
		myText.setPrefSize(WIDTH, height);
		myConsolePane.getChildren().add(myLabel);
        myPane.setContent(myText);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(height);
        myConsolePane.getChildren().add(myPane);
	}
	
	public VBox getConsole(){
		return myConsolePane;
	}
	
	public TextArea getHistoryTextArea(){
		return myHistoryText; 
	}
	
	


}