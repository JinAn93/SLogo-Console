package fxFrontend;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class ScreenSidebar {
    private VBox myConsole;
    private ScrollPane myTurtleStats, myUserCommands, myVariables;
    private Label myTurtleLabel, myUserLabel, myVariablesLabel;
    private TextArea myTurtleText, myUserText, myVariablesText;
    private Button myHelpButton, myNewWorkspaceButton;
    private static final String HELP_LABEL = "Help";
    private static final String VARIABLE_LABEL = "Variables:";
    private static final String VARIABLE_COLUMN = "Variable";
    private static final String VARIABLE_NAME = "variableName";
    private static final String VARIABLE_VALUE = "variableValue";
    private static final String VALUE_LABEL = "Value";
    private static final String SLOGO_URL =
            "http://www.cs.duke.edu/courses/spring16/compsci308/assign/03_slogo/commands.php";
    private static final int STAGE_WIDTH = 500;
    private static final int STAGE_HEIGHT = 500;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 180;
    private TableView myVariablesTable;
    private TableColumn variableCol, valueCol;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ScreenSidebar () {
        myConsole = new VBox(20); // spacing = 8
        myTurtleStats = new ScrollPane();
        myTurtleLabel = new Label("Turtle Stats:");
        myTurtleText = new TextArea();
        myTurtleText.setEditable(false);
        createBox(myTurtleLabel, myTurtleStats, myTurtleText);
        myUserCommands = new ScrollPane();
        myUserLabel = new Label("User Commands:");
        myUserText = new TextArea();
        myUserText.setEditable(false);
        createBox(myUserLabel, myUserCommands, myUserText);
        createVarTable();
        createTableView(myVariablesLabel, myVariables, myVariablesTable);
        createHelpButton();
        createWorkSpaceButton();
    }

    private void createWorkSpaceButton () {
        myNewWorkspaceButton = new Button("New Turtle Screen");
        myConsole.getChildren().add(myNewWorkspaceButton);
        myNewWorkspaceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                Stage myNewStage = new Stage();
                FxMain fx = new FxMain();
                fx.start(myNewStage);
            }
        });
    }

    private void createHelpButton () {
        myHelpButton = new Button("Help");
        myConsole.getChildren().add(myHelpButton);
        myHelpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                createResourceLink();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void createVarTable () {
        myVariables = new ScrollPane();
        myVariablesLabel = new Label(VARIABLE_LABEL);
        myVariablesTable = new TableView();
        variableCol = new TableColumn(VARIABLE_COLUMN);

        valueCol = new TableColumn(VALUE_LABEL);
        variableCol.setCellValueFactory(
                new PropertyValueFactory<DisplayObject, String>(VARIABLE_NAME)
                );
        valueCol.setCellValueFactory(
                new PropertyValueFactory<DisplayObject, Double>(VARIABLE_VALUE)
                );
        myVariablesTable.getColumns().addAll(variableCol, valueCol);
    }

    private void createResourceLink () {
        Stage myStage = new Stage();
        myStage.setTitle(HELP_LABEL);
        myStage.setWidth(STAGE_WIDTH);
        myStage.setHeight(STAGE_HEIGHT);
        Scene scene = new Scene(new Group());
        VBox root = new VBox();
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        Hyperlink hypLink = new Hyperlink(SLOGO_URL);
        webEngine.load(SLOGO_URL);
        root.getChildren().addAll(hypLink, browser);
        scene.setRoot(root);
        myStage.setScene(scene);
        myStage.show();
    }

    private void createBox (Label myLabel, ScrollPane myPane, TextArea myText) {
        myConsole.getChildren().add(myLabel);
        myPane.setContent(myText);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(HEIGHT);
        myConsole.getChildren().add(myPane);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void createTableView (Label myLabel, ScrollPane myPane, TableView myText) {
        myConsole.getChildren().add(myLabel);
        myPane.setContent(myText);
        myPane.setFitToWidth(true);
        myPane.setPrefWidth(WIDTH);
        myPane.setPrefHeight(HEIGHT);
        myConsole.getChildren().add(myPane);
    }

    public VBox getBox () {
        return myConsole;
    }

    public TextArea getArea () {
        return myTurtleText;
    }

    public TableView getTable () {
        return myVariablesTable;
    }

    public TextArea getUserCommandArea () {
        return myUserText;
    }

}
