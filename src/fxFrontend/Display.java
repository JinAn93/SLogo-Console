package fxFrontend;
import Main.MainBackEnd;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
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
	private TextArea historyBox; 
	private StringBuilder commandHistory = new StringBuilder();
	private GraphicsContext myGraphics;
	private Image myImage;
	private Canvas myCanvas;
	private int myX,myY;
	
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
        historyBox = myConsole.getHistoryTextArea();
        myButton = myScreen.getButton();
        myCanvas = myScreen.getCanvas();
        myGraphics = myScreen.getGraphics();
        myImage = myScreen.getTurtleImage();
    	myX = myScreen.getTurtleX();
    	myY = myScreen.getTurtleY();
        updateDisplay(); 
	}
	
	public void updateDisplay(){
		myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	commandHistory.append(myScreen.getCodeInput().getText() + "\n");
            	historyBox.setText(commandHistory.toString());
            	myY = myY+50;
            	myX = myX+40;
            	myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        		myGraphics.fillRect(0,0,myCanvas.getWidth(),myCanvas.getHeight());
            	myGraphics.drawImage(myImage, myX, myY);
//            	MainBackEnd myCommand = new MainBackEnd();
//            	String[] commands = myCommand.setup(myScreen.getCodeInput().getText());
//            	myCommand.executeCommand(commands);
            	
            }
        });
	}
	
	public Scene getScene(){
		return myScene;
	}
}