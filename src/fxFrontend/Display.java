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
import Main.InputObject;
import fxMenu.CreateColorMenu;
import fxMenu.CreatePenColorMenu;
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
    private TextArea historyBox, myConsoleBox, myTurtleStatsBox;
    private StringBuilder commandHistory = new StringBuilder();
    private String consoleText;
    private GraphicsContext myGraphics, myColorGraphics, myLineGraphics;
    private Canvas myCanvas;
    private Turtle myTurtle;
    private Alert alert = new Alert(AlertType.INFORMATION);
    private MenuBar myMenu;
    private CreateColorMenu createMenu;
    private CreateTurtleSelectionMenu myTurtleImages;
    private CreatePenColorMenu myPenMenu; 
    private ArrayList<Line> myLines;
    private Output output; 
    private TableView myVariablesTable;
    private TableColumn variableCol, valueCol;
    private ObservableList<DisplayVariable> data;
    
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
        myTurtleStatsBox = mySidebar.getArea();
        myButton = myScreen.getButton();
        myCanvas = myScreen.getCanvas();
        myGraphics = myScreen.getGraphics();
        myColorGraphics = myScreen.getColorGraphics();
        myLineGraphics = myScreen.getLineGraphics();
        myLines = new ArrayList<Line>();
        myMenu = new MenuBar();
        createMenu = new CreateColorMenu(myColorGraphics, 600, 600);
        myMenu.getMenus().add(createMenu.getColorMenu());
        myTurtleImages = new CreateTurtleSelectionMenu(myTurtle);
        myMenu.getMenus().add(myTurtleImages.getImageMenu());
        myPenMenu = new CreatePenColorMenu(myGraphics); 
        myMenu.getMenus().add(myPenMenu.getPenMenu());
        myBorder.setTop(myMenu);
        //make the table
        
        myVariablesTable = mySidebar.getTable();
        variableCol = new TableColumn("Variable");

        valueCol = new TableColumn("Value");
        variableCol.setCellValueFactory(
        	    new PropertyValueFactory<DisplayVariable,String>("variableName")
        	);
        valueCol.setCellValueFactory(
        	    new PropertyValueFactory<DisplayVariable,Double>("variableValue")
        	);
        data = FXCollections.observableArrayList(); // create the data
        myVariablesTable.setItems(data);
        myVariablesTable.getColumns().addAll(variableCol,valueCol);



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
                System.out.println("hey output not made yet");
                output = mb.executeCommand(parsedCommands);
                
                System.out.println("hey output made");
                
                consoleText = output.getResult().toString();
                myConsoleBox.setText(consoleText);
                
                String myTurtleStats = "X Coordinate:"+myTurtle.getStartXCor() +"\n"+ "Y Coordinate:" + myTurtle.getStartYCor();
                myTurtleStatsBox.setText(myTurtleStats);
                
                List<Variable> myVarList = output.getVariables();
                for(Variable aVar: myVarList){
                	DisplayVariable tempVar = new DisplayVariable(aVar.getName(),aVar.getValue());
                	if(!contains(myVariablesTable,tempVar)){
                    	myVariablesTable.getItems().add(tempVar);
                    }
                }
               
            }
        });
    }
    
    public boolean contains(TableView<DisplayVariable> table, DisplayVariable obj){
        for(DisplayVariable item: table.getItems())
            if (item.getVariableName().equals(obj.getVariableName()))
                return true;

        return false;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
    public GraphicsContext getMyGraphics(){
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
            Double XCoor = myTurtle.getStartXCor();
            Double YCoor = myTurtle.getStartYCor();
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
            // Override this tomorrow when we get to lines
            //Drawing stuff 
//            if(PenDown == 1){
//            	double startX = output.getTurtle().getStartXCor();
//            	double startY = output.getTurtle().getStartYCor();
//            	if(myLines.isEmpty()){
//            		updateLines(XCoor, YCoor, output.getTurtle().getEndXCor(), output.getTurtle().getEndYCor());
//            	}
//            	else{
//            		updateLines(startX, startY, output.getTurtle().getEndXCor(), output.getTurtle().getEndYCor());
//            	}
//            }
        }
        

        
        public void updateLines(double beginX, double beginY, double endX, double endY){
        	Line myLine = new Line(beginX, beginY, endX, endY);
        	myLines.add(myLine); 
        	for(Line aline: myLines){
        		myGraphics.strokeLine(aline.getBeginX(), aline.getBeginY(), aline.getEndX(), aline.getEndY());
        	}	
        }
        
    
    }
}
