package fxFrontend;

import Main.MainBackEnd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import fxFrontend.DisplayObject;

import java.io.IOException;
import java.util.*;
import Commands.Variable;
import Main.Output;
import Main.Turtle;
import Error_Checking.ErrorObject;
import Main.InputObject;
import fxMenu.SlogoMenuCreator;
import javafx.scene.transform.Rotate;
import fxFrontend.Line;
import fxFrontend.LanguageReader;

public class Display {
    private BorderPane myBorder;
    private Scene myScene;
    private CreateSidebar mySidebar = new CreateSidebar();
    private CreateTurtleScreen myScreen = new CreateTurtleScreen();
    private CreateConsole myConsole = new CreateConsole();
    private TextArea historyBox, myConsoleBox, myTurtleStatsBox;
    private StringBuilder commandHistory = new StringBuilder();
    private GraphicsContext myGraphics, myColorGraphics, myLineGraphics;
    private Turtle myTurtle;
    private TableView<DisplayObject> myVariablesTable;
    private ObservableList<DisplayObject> data;
    private List<Variable> myVarList;
    private Output output;
    private LanguageReader myReader;
    private InputObject myInput;

    public Display () {
        myBorder = new BorderPane();
		myReader = new LanguageReader();
		try {
			myReader.load("English");
		} catch (IOException e) {
			System.out.println("Wrong file");
			System.exit(1);
		}
		System.out.println(myReader.getString("Forward"));

        displayScreen();
        myBorder.setPadding(new Insets(10, 20, 10, 20));
        myScene = new Scene(myBorder, 1100, 800);
    }

    @SuppressWarnings({ "unchecked" })
    public void displayScreen () {
        VBox leftBox = mySidebar.getBox();
        VBox centerBox = myScreen.getScreen();
        VBox consoleBox = myConsole.getConsole();
        myBorder.setLeft(leftBox);
        myBorder.setCenter(centerBox);
        myBorder.setRight(consoleBox);
        myTurtle = myScreen.getMyTurtle();
        historyBox = myConsole.getHistoryTextArea();
        myConsoleBox = myConsole.getConsoleText();
        myTurtleStatsBox = mySidebar.getArea();
        myGraphics = myScreen.getGraphics();
        myColorGraphics = myScreen.getColorGraphics();
        myLineGraphics = myScreen.getLineGraphics();
        SlogoMenuCreator menuCreator =
                new SlogoMenuCreator(myTurtle, myColorGraphics, myLineGraphics);
        MenuBar myMenu = menuCreator.getMenuBar();
        myBorder.setTop(myMenu);
        myVariablesTable = mySidebar.getTable();
        data = FXCollections.observableArrayList(); // create the data
        myVariablesTable.setItems(data);
        updateTurtleStats();
        updateDisplay();
    }

    public void updateDisplay () {
        Button myButton = myScreen.getButton();
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                String myCommand = myScreen.getCodeInput().getText();
                MainBackEnd mb = new MainBackEnd();
                myInput = new InputObject(myCommand, myTurtle);
                Collection<?> parsedCommands = mb.setup(myCommand, myInput);
                output = mb.executeCommand(parsedCommands);
                if (output != null) {
                    String consoleText = output.getResult().toString();
                    myConsoleBox.setText(consoleText);
                    commandHistory.append(myCommand + "\n");
                    historyBox.setText(commandHistory.toString());
                    updateTurtleStats();
                    iterateVar();
                    updateTurtle();
                }
            }
        });
    }

    public void updateTurtleStats () {
        String xCoor = "X Coordinate: " + myTurtle.getStartXCor() + "\n";
        String yCoor = "Y Coordinate: " + myTurtle.getStartYCor() + "\n";
        String heading = "Heading: " + myTurtle.getHeading() + "\n";
        String pen = "Pen: Down" + "\n";
        if (myTurtle.getPen() == 0) {
            pen = "Pen: Up" + "\n";
        }
        String turtleHeading = "Turtle Heading: " + myTurtle.getHeading() + "\n";

        String myTurtleStats = xCoor + yCoor + pen + turtleHeading;

        myTurtleStatsBox.setText(myTurtleStats);
    }

    public void updateTurtle () {
        double xCoor = myTurtle.getEndXCor();
        double yCoor = myTurtle.getEndYCor();
        double head = myTurtle.getHeading();
        int visib = myTurtle.getVisibility();

        if (visib == 1) {
            myGraphics.drawImage(myTurtle.getTurtleImage(), xCoor, yCoor);
            rotate(myGraphics, head, calculatePivotX(myTurtle), calculatePivotY(myTurtle));
            myGraphics.clearRect(0, 0, 600, 600);
            myGraphics.fillRect(0, 0, 600, 600);
            myGraphics.drawImage(myTurtle.getTurtleImage(), xCoor, yCoor);
        }
        else {
            myGraphics.clearRect(0, 0, 600, 600);
        }
    }

    public void iterateVar () {
        myVarList = output.getVariables();
        for (Variable aVar : myVarList) {
            DisplayObject tempVar = new DisplayObject(aVar.getName(), aVar.getValue());
            if (!contains(myVariablesTable, tempVar)) {
                myVariablesTable.getItems().add(tempVar);
            }
        }
    }

    public void clearScreen () {
        myGraphics.clearRect(0, 0, 600, 600);
        myGraphics.fillRect(0, 0, 600, 600);
        myLineGraphics.clearRect(0, 0, 600, 600);
        myGraphics.fillRect(0, 0, 600, 600);
    }

    public void updateLines () {

        double startX = myTurtle.getStartXCor();
        double startY = myTurtle.getStartYCor();
        double endX = myTurtle.getEndXCor();
        double endY = myTurtle.getEndYCor();
        if (myTurtle.getPen() == 1) {
            myLineGraphics.setLineWidth(myTurtle.getPenWidth());
            myLineGraphics.strokeLine(startX, startY, endX, endY);
        }
        myTurtle.setStartXCor(endX);
        myTurtle.setStartYCor(endY);

    }

    public boolean contains (TableView<DisplayObject> table, DisplayObject obj) {
        for (DisplayObject item : table.getItems())
            if (item.getVariableName().equals(obj.getVariableName()))
                return true;
        return false;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }

    public GraphicsContext getMyGraphics () {
        return myGraphics;
    }

    private double calculatePivotX (Turtle turtle) {
        return (turtle.getStartXCor() + (turtle.getTurtleImage().getWidth() / 2));
    }

    private double calculatePivotY (Turtle turtle) {
        return (turtle.getStartYCor() + (turtle.getTurtleImage().getHeight() / 2));
    }

    private void rotate (GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    // *Testing new stuff
    private void drawRotatedImage (GraphicsContext gc, double angle, double tlpx, double tlpy) {
        gc.save();
        Image turtleImage = myTurtle.getTurtleImage();
        rotate(gc, angle, tlpx + turtleImage.getWidth() / 2, tlpy + turtleImage.getHeight() / 2);
        gc.drawImage(turtleImage, tlpx, tlpy);
        gc.restore();
    }

    public Scene getScene () {
        return myScene;
    }

    public class ObserveTurtle implements Observer {
        @Override
        public void update (Observable obs, Object turtle) {
            updateLines();
        }
    }
    
    public InputObject getInput(){
    	return myInput; 
    }
}
