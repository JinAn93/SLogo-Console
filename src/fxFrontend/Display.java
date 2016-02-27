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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;
import Main.Output;
import Main.Turtle;
import Main.InputObject;


public class Display {
    private BorderPane myBorder;
    private Scene myScene;
    private VBox leftBox, centerBox, consoleBox;
    private CreateSidebar mySidebar = new CreateSidebar();
    private CreateTurtleScreen myScreen = new CreateTurtleScreen();
    private CreateConsole myConsole = new CreateConsole();
    private Button myButton;
    private TextArea historyBox, myConsoleBox;
    private StringBuilder commandHistory = new StringBuilder();
    private String consoleText;
    private GraphicsContext myGraphics;
    private Image myImage;
    private Canvas myCanvas;
    private int myX, myY;
    private Turtle myTurtle;
    private Alert alert = new Alert(AlertType.INFORMATION);

    public Display () {
        myBorder = new BorderPane();
        displayScreen();
        myBorder.setPadding(new Insets(10, 20, 10, 20));
        myScene = new Scene(myBorder, 1100, 800);
    }

    public void displayScreen () {
        leftBox = mySidebar.getBox();
        centerBox = myScreen.getScreen();
        consoleBox = myConsole.getConsole();
        myBorder.setLeft(leftBox);
        myBorder.setCenter(centerBox);
        myBorder.setRight(consoleBox);
        myTurtle = myScreen.getMyTurtle();
        historyBox = myConsole.getHistoryTextArea();
        myConsoleBox = myConsole.getConsoleText();
        myButton = myScreen.getButton();
        myCanvas = myScreen.getCanvas();
        myGraphics = myScreen.getGraphics();
        myImage = myScreen.getMyTurtle().getTurtleImage();
        myX = myTurtle.getXCor();
        myY = myTurtle.getYCor();
        updateDisplay();
    }

    public void updateDisplay () {
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                String myCommand = myScreen.getCodeInput().getText();
                MainBackEnd mb = new MainBackEnd();
                commandHistory.append(myCommand + "\n");
                historyBox.setText(commandHistory.toString());
                InputObject myInput = new InputObject(myCommand, myTurtle);
                Collection<?> parsedCommands = mb.setup(myCommand, myInput);
                Output output = mb.executeCommand(parsedCommands);
                consoleText = output.getResult().toString();
                myConsoleBox.setText(consoleText);

                // if(!myScreen.getCodeInput().getText().equals("hi")){ //Alert for bad commands
                // alert.setTitle("Error Dialog");
                // alert.setHeaderText("Error processing the command");
                // alert.setContentText("\"" + myScreen.getCodeInput().getText() +
                // "\" is not a valid command. Please input a valid command");
                // alert.showAndWait();
                // }
                // else{
                // commandHistory.append(myScreen.getCodeInput().getText() + "\n");
                // System.out.println(myScreen.getCodeInput().getText());
                // historyBox.setText(commandHistory.toString());
                // myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                // myGraphics.fillRect(0,0,myCanvas.getWidth(),myCanvas.getHeight());
                //
                // myY = myY+50;
                // myX = myX+40;
                // myGraphics.drawImage(myImage, myX, myY);
                // myScreen.getMyTurtle().setXCor(myX);
                // myScreen.getMyTurtle().setYCor(myY);
                //
                // }
            }
        });
    }

    public Scene getScene () {
        return myScene;
    }
}
