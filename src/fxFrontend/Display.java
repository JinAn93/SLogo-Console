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
import fxFrontend.DisplayVariable;
import java.util.*;
import Commands.Variable;
import Main.Output;
import Main.Turtle;
import Main.ErrorObject;
import Main.InputObject;
import fxMenu.CreateBackgroundColorMenu;
import fxMenu.CreatePenColorMenu;
import fxMenu.CreatePenPropertiesMenu;
import fxMenu.CreateTurtleSelectionMenu;
import fxMenu.SlogoMenuCreator;
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
    private TextArea historyBox, myConsoleBox, myTurtleStatsBox;
    private StringBuilder commandHistory = new StringBuilder();
    private String consoleText;
    private GraphicsContext myGraphics, myColorGraphics, myLineGraphics;
    private Canvas myCanvas;
    private Turtle myTurtle;
    private MenuBar myMenu;
    private SlogoMenuCreator menuCreator;
    private Output output;
    @SuppressWarnings("rawtypes")
	private TableView myVariablesTable;
    @SuppressWarnings("rawtypes")
	private TableColumn variableCol, valueCol;
    private ObservableList<DisplayVariable> data;
    
    public Display () {
        myBorder = new BorderPane();
        displayScreen();
        myBorder.setPadding(new Insets(10, 20, 10, 20));
        myScene = new Scene(myBorder, 1100, 800);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
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
        myTurtleStatsBox = mySidebar.getArea();
        myButton = myScreen.getButton();
        myCanvas = myScreen.getCanvas();
        myGraphics = myScreen.getGraphics();
        myColorGraphics = myScreen.getColorGraphics();
        myLineGraphics = myScreen.getLineGraphics();
        //create Menu
        menuCreator = new SlogoMenuCreator(myTurtle,myColorGraphics,myLineGraphics);
        myMenu = menuCreator.getMenuBar();
        myBorder.setTop(myMenu);

        myVariablesTable = mySidebar.getTable();
        variableCol = new TableColumn("Variable");

        valueCol = new TableColumn("Value");
        variableCol.setCellValueFactory(
                new PropertyValueFactory<DisplayVariable, String>("variableName")
                );
        valueCol.setCellValueFactory(
                new PropertyValueFactory<DisplayVariable, Double>("variableValue")
                );
        data = FXCollections.observableArrayList(); // create the data
        myVariablesTable.setItems(data);
        myVariablesTable.getColumns().addAll(variableCol, valueCol);

        updateDisplay();
    }

    public void updateDisplay () {
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("unchecked")
			public void handle (ActionEvent e) {
                String myCommand = myScreen.getCodeInput().getText();
                MainBackEnd mb = new MainBackEnd();
                commandHistory.append(myCommand + "\n");
                historyBox.setText(commandHistory.toString());
                InputObject myInput = new InputObject(myCommand, myTurtle);
                Collection<?> parsedCommands = mb.setup(myCommand, myInput);
                output = mb.executeCommand(parsedCommands);

                consoleText = output.getResult().toString();
                myConsoleBox.setText(consoleText);

                String myTurtleStats =
                        "X Coordinate:" + myTurtle.getStartXCor() + "\n" + "Y Coordinate:" +
                                myTurtle.getStartYCor();
                myTurtleStatsBox.setText(myTurtleStats);

                List<Variable> myVarList = output.getVariables();
                for (Variable aVar : myVarList) {
                    DisplayVariable tempVar = new DisplayVariable(aVar.getName(), aVar.getValue());
                    if (!contains(myVariablesTable, tempVar)) {
                        myVariablesTable.getItems().add(tempVar);
                    }
                }
                double XCoor = myTurtle.getEndXCor();
                double YCoor = myTurtle.getEndYCor();
                double Head = myTurtle.getHeading();
                int Visib = myTurtle.getVisibility();
                int PenDown = myTurtle.getPen();
                System.out.printf("PEN IS: %s\n",PenDown);

                if (Visib == 1) {
                    myGraphics.drawImage(myTurtle.getTurtleImage(), XCoor, YCoor);
                    rotate(myGraphics, Head, calculatePivotX(myTurtle), calculatePivotY(myTurtle));
                    myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                    myGraphics.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                    myGraphics.drawImage(myTurtle.getTurtleImage(), XCoor, YCoor);
                }
                else {
                    myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                }

            }
        });
    }
    
    public void clearScreen(){
    	myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
    	myGraphics.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
    	myLineGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
    	myGraphics.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
    }

    public void updateLines () {
    	
        double startX = myTurtle.getStartXCor();
        double startY = myTurtle.getStartYCor();
        double endX = myTurtle.getEndXCor();
        double endY = myTurtle.getEndYCor();
        if(myTurtle.getPen()==1){
        	myLineGraphics.setLineWidth(myTurtle.getPenWidth());
        	myLineGraphics.strokeLine(startX, startY, endX, endY);
        }
        myTurtle.setStartXCor(endX);
        myTurtle.setStartYCor(endY);
        
    }

    public boolean contains (TableView<DisplayVariable> table, DisplayVariable obj) {
        for (DisplayVariable item : table.getItems())
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

    public Scene getScene () {
        return myScene;
    }

    public class ObserveTurtle implements Observer {
        @Override
        public void update (Observable obs, Object turtle) {
        	updateLines();
        }
    }
}
