package fxFrontend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import BackEndMain.InputObject;
import BackEndMain.MainBackEnd;
import BackEndMain.Output;
import BackEndMain.StrConstant;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;
import Turtle.Turtle;
import fxMenu.SlogoMenuCreator;


public class Display {
    private BorderPane myBorder;
    private Scene myScene;
    private ScreenSidebar mySidebar = new ScreenSidebar();
    private TurtleScreen myScreen;
    private ScreenConsole myConsole = new ScreenConsole();
    private TextArea historyBox, myConsoleBox, myTurtleStatsBox, myUserCommandsBox;
    private StringBuilder commandHistory, userCommandHistory;
    private GraphicsContext myGraphics, myColorGraphics, myLineGraphics;
    private List<SingleTurtle> myAllTurtles;
    private TableView<DisplayObject> myVariablesTable;
    private ObservableList<DisplayObject> data;
    private List<Variable> myVarList;
    private Output output;
    private static final ResourceBundle defaultLang = ResourceBundle
            .getBundle(StrConstant.DEFAULTLANG);
    private ResourceBundle myLang = defaultLang;
    private InputObject myInput;
    private List<Integer> myInactiveList = new ArrayList<Integer>();
    private int myNumberUseTurtles;
    private static final int BORDER_WIDTH = 10;
    private static final int BORDER_HEIGHT = 20;
    private static final int SCENE_WIDTH = 1100;
    private static final int SCENE_HEIGHT = 800;

    public Display (int numb) {
        myNumberUseTurtles = numb;
        myScreen = new TurtleScreen(myNumberUseTurtles);
        commandHistory = new StringBuilder();
        userCommandHistory = new StringBuilder();
        myBorder = new BorderPane();
        displayScreen();
        myBorder.setPadding(new Insets(BORDER_WIDTH, BORDER_HEIGHT, BORDER_WIDTH, BORDER_HEIGHT));
        myScene = new Scene(myBorder, SCENE_WIDTH, SCENE_HEIGHT);
    }

    @SuppressWarnings({ "unchecked" })
    public void displayScreen () {
        alignBorder();
        setUpDisplay();
        SlogoMenuCreator menuCreator =
                new SlogoMenuCreator(myAllTurtles, myColorGraphics, myLineGraphics, this,
                                     myInactiveList, myAllTurtles);
        MenuBar myMenu = menuCreator.getMenuBar();
        myBorder.setTop(myMenu);
        myVariablesTable = mySidebar.getTable();
        data = FXCollections.observableArrayList(); // create the data
        myVariablesTable.setItems(data);
        DisplayUpdater dispUpdate = new DisplayUpdater(myAllTurtles, myGraphics);
        myTurtleStatsBox.setText(dispUpdate.updateTurtleStats());
        updateDisplay();
    }

    private void setUpDisplay () {
        myAllTurtles = myScreen.getMyTurtle();
        historyBox = myConsole.getHistoryTextArea();
        myConsoleBox = myConsole.getConsoleText();
        myTurtleStatsBox = mySidebar.getArea();
        myUserCommandsBox = mySidebar.getUserCommandArea();
        myGraphics = myScreen.getGraphics();
        myColorGraphics = myScreen.getColorGraphics();
        myLineGraphics = myScreen.getLineGraphics();
    }

    private void alignBorder () {
        VBox leftBox = mySidebar.getBox();
        VBox centerBox = myScreen.getScreen();
        VBox consoleBox = myConsole.getConsole();
        myBorder.setLeft(leftBox);
        myBorder.setCenter(centerBox);
        myBorder.setRight(consoleBox);
    }

    public void updateDisplay () {
        Button myButton = myScreen.getButton();
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                String myCommand = myScreen.getCodeInput().getText();
                MainBackEnd mb = new MainBackEnd();
                myInput = new InputObject(myCommand, myAllTurtles, myLang);
                Collection<?> parsedCommands = mb.setup(myInput);
                output = mb.executeCommand(parsedCommands);
                if (output != null) {
                    statUpdater(myCommand);
                    DisplayUpdater dispUpdate = new DisplayUpdater(myAllTurtles, myGraphics);
                    myTurtleStatsBox.setText(dispUpdate.updateTurtleStats());
                    iterateVar();
                    dispUpdate.updateTurtle();
                }
            }
        });
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
            if (aturtle.getActive() == true) {
                double startX = aturtle.getStartXCor();
                double startY = aturtle.getStartYCor();
                double endX = aturtle.getEndXCor();
                double endY = aturtle.getEndYCor();
                if (aturtle.getPen() == 1) {
                    if (aturtle.getPenDashed()) {
                        myLineGraphics.setLineDashes(5);
                    }
                    else {
                        myLineGraphics.setLineDashes(0);
                    }
                    myLineGraphics.setLineWidth(aturtle.getPenWidth());
                    myLineGraphics.strokeLine(startX, startY, endX, endY);
                }
                aturtle.setStartXCor(endX);
                aturtle.setStartYCor(endY);
            }
        }
    }

    public boolean contains (TableView<DisplayObject> table, DisplayObject obj) {
        for (DisplayObject item : table.getItems()) {
            if (item.getVariableName().equals(obj.getVariableName()) &&
                item.getVariableValue().equals(obj.getVariableValue())) {
                return true;
            }
            else if (item.getVariableName().equals(obj.getVariableName()) &&
                     !item.getVariableValue().equals(obj.getVariableValue())) {
                table.getItems().remove(item);
                return false;
            }
        }
        return false;
    }

    public List<SingleTurtle> getTurtle () {
        return myAllTurtles;
    }

    public GraphicsContext getMyGraphics () {
        return myGraphics;
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

    private void statUpdater (String myCommand) {
        String consoleText = output.getResult().toString();
        myConsoleBox.setText(consoleText);
        commandHistory.append(myCommand + "\n");
        for (UserCommand myUserCommand : output.getUserCommands()) {
            userCommandHistory.append(myUserCommand.getUserCommandName());
        }
        myUserCommandsBox.setText(userCommandHistory.toString());
        historyBox.setText(commandHistory.toString());
    }
}
