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
    private List<Turtle> myAllTurtles;
    private TableView<DisplayObject> myVariablesTable;
    private ObservableList<DisplayObject> data;
    private List<Variable> myVarList;
    private Output output;
    private LanguageReader myReader;
    private static final ResourceBundle defaultLang = ResourceBundle.getBundle("languagefiles/English");
    private ResourceBundle myLang = defaultLang;
    private InputObject myInput;
    private List<Integer> myInactiveList = new ArrayList<Integer>();
    
    public Display () {
        myBorder = new BorderPane();
        myReader = new LanguageReader();
        try {
            myReader.load("English");
        }
        catch (IOException e) {
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
        myAllTurtles = myScreen.getMyTurtle();
        historyBox = myConsole.getHistoryTextArea();
        myConsoleBox = myConsole.getConsoleText();
        myTurtleStatsBox = mySidebar.getArea();
        myGraphics = myScreen.getGraphics();
        myColorGraphics = myScreen.getColorGraphics();
        myLineGraphics = myScreen.getLineGraphics();
        SlogoMenuCreator menuCreator =
        new SlogoMenuCreator(myAllTurtles, myColorGraphics, myLineGraphics, this, myInactiveList, myAllTurtles);
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
                System.out.println(myInactiveList);
                
                String myCommand = myScreen.getCodeInput().getText();
                MainBackEnd mb = new MainBackEnd();
                myInput = new InputObject(myCommand, myAllTurtles, myLang);
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
        StringBuilder myTurtleStats = new StringBuilder();
        int i = 0;
        for (Turtle aTurtle : myAllTurtles) {
            myTurtleStats.append("Turtle Number " + i + "\n");
            myTurtleStats.append("X Coordinate: " + aTurtle.getStartXCor() + "\n");
            myTurtleStats.append("Y Coordinate: " + aTurtle.getStartYCor() + "\n");
            myTurtleStats.append("Heading: " + aTurtle.getHeading() + "\n");
            if (aTurtle.getPen() == 1) {
                myTurtleStats.append("Pen: Down" + "\n");
            }
            else {
                myTurtleStats.append("Pen: Up" + "\n");
            }
            myTurtleStats.append("Turtle Heading:" + aTurtle.getHeading() + "\n");
            myTurtleStats.append("Turtle active:"+aTurtle.getActive() + "\n");
            myTurtleStats.append("\n");
            i++;
        }
        myTurtleStatsBox.setText(myTurtleStats.toString());
    }
    
    public void updateTurtle () {
        int a = 0;
        double[] xCoor = new double[myAllTurtles.size()];
        double[] yCoor = new double[myAllTurtles.size()];
        double[] head = new double[myAllTurtles.size()];
        int[] visib = new int[myAllTurtles.size()];
        myGraphics.clearRect(0, 0, 600, 600);
        myGraphics.fillRect(0, 0, 600, 600);
        
        for (Turtle aturtle : myAllTurtles) {
            xCoor[a] = aturtle.getEndXCor();
            yCoor[a] = aturtle.getEndYCor();
            head[a] = aturtle.getHeading();
            visib[a] = aturtle.getVisibility();
            a++;
        }
        a = 0;
        for (Turtle aturtle : myAllTurtles) {
            if (visib[a] == 1) {
                myGraphics.drawImage(aturtle.getTurtleImage(), xCoor[a], yCoor[a]);
            }
            rotate(myGraphics, head[a], calculatePivotX(aturtle), calculatePivotY(aturtle));
            a++;
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
        
        for (Turtle aturtle : myAllTurtles) {
        	if(aturtle.getActive()==true){
            double startX = aturtle.getStartXCor();
            double startY = aturtle.getStartYCor();
            double endX = aturtle.getEndXCor();
            double endY = aturtle.getEndYCor();
            if (aturtle.getPen() == 1) {
                myLineGraphics.setLineWidth(aturtle.getPenWidth());
                myLineGraphics.strokeLine(startX, startY, endX, endY);
            }
            aturtle.setStartXCor(endX);
            aturtle.setStartYCor(endY);
        	}
        }
        
    }
    
    public boolean contains (TableView<DisplayObject> table, DisplayObject obj) {
        for (DisplayObject item : table.getItems())
            if (item.getVariableName().equals(obj.getVariableName()))
                return true;
        return false;
    }
    
    public List<Turtle> getTurtle () {
        return myAllTurtles;
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
        for (Turtle aturtle : myAllTurtles) {
            Image turtleImage = aturtle.getTurtleImage();
            rotate(gc, angle, tlpx + turtleImage.getWidth() / 2, tlpy + turtleImage.getHeight() / 2);
            gc.drawImage(turtleImage, tlpx, tlpy);
            gc.restore();
        }
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
    
    public void setLanguage (ResourceBundle language) {
        myLang = language;
    }
    
}