package fxFrontend;

import Main.MainBackEnd;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;
import Main.Output;
import Main.Turtle;
import Main.InputObject;
import fxMenu.CreateColorMenu;
import fxMenu.CreateTurtleSelectionMenu;
import javafx.scene.transform.Rotate;
import fxFrontend.Line;

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
    private GraphicsContext myGraphics, myColorGraphics;
    private Canvas myCanvas;
    private Turtle myTurtle;
    private Alert alert = new Alert(AlertType.INFORMATION);
    private MenuBar myMenu;
    private CreateColorMenu createMenu;
    private CreateTurtleSelectionMenu myTurtleImages;
    private ArrayList<Line> myLines;

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
        myColorGraphics = myScreen.getColorGraphics();
        myLines = new ArrayList<Line>();

        myMenu = new MenuBar();
        createMenu = new CreateColorMenu(myColorGraphics, 600, 600);
        myMenu.getMenus().add(createMenu.getColorMenu());
        myTurtleImages = new CreateTurtleSelectionMenu(myTurtle);
        myMenu.getMenus().add(myTurtleImages.getImageMenu());
        myBorder.setTop(myMenu);

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

            }
        });
    }

    public Turtle getTurtle() {
        return myTurtle;
    }
    
    private double calculatePivotX (Turtle turtle) {
        return (turtle.getXCor() + (turtle.getTurtleImage().getWidth() / 2));
    }

    private double calculatePivotY (Turtle turtle) {
        return (turtle.getYCor() + (turtle.getTurtleImage().getHeight() / 2));
    }

    private void rotate (GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    public Scene getScene () {
        return myScene;
    }
    
    public class ObserveTurtle implements Observer {

        @Override
        public void update(Observable obs, Object turtle){
            Double XCoor = myTurtle.getXCor();
            Double YCoor = myTurtle.getYCor();
            Double Head = myTurtle.getHeading();
            int Visib = myTurtle.getVisibility();
            int PenDown = myTurtle.getPen();
            
            if (Visib == 1) {
                myGraphics.drawImage(myTurtle.getTurtleImage(), XCoor, YCoor);
            }
            else {
                myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
            }
            
            rotate(myGraphics, Head, calculatePivotX(myTurtle), calculatePivotY(myTurtle));
                           
            myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
            myGraphics.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
            myGraphics.drawImage(myTurtle.getTurtleImage(), XCoor, YCoor);
            //Override this tomorrow when we get to lines
            Line myLine = new Line(0,0,XCoor,YCoor);
            myLines.add(myLine);
            for(Line aline: myLines){
            	myGraphics.strokeLine(aline.getBeginX(), aline.getBeginY(), aline.getEndX(), aline.getEndY());
            }
        }
        
    }
}
