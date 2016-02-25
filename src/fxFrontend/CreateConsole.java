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
		createBox(myHistoryLabel, myHistory, 350+HEIGHT);
		
		myConsole = new ScrollPane();
		myConsoleLabel = new Label("Console:");
		createBox(myConsoleLabel, myConsole, HEIGHT);

	}
	
	private void createBox(Label myLabel, ScrollPane myPane, int height){
		TextArea textArea = new TextArea();
		textArea.setPrefSize(WIDTH, height);
		myConsolePane.getChildren().add(myLabel);
        myPane.setContent(textArea);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(height);
        myConsolePane.getChildren().add(myPane);
	}
	
	public VBox getConsole(){
		return myConsolePane;
	}


}
