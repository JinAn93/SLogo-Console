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
    private Image myImage;
    private Canvas myCanvas;
    private double myX, myY;
    private Turtle myTurtle;
    private Alert alert = new Alert(AlertType.INFORMATION);
    private MenuBar myMenu;
    private CreateColorMenu createMenu;
    private CreateTurtleSelectionMenu myTurtleImages;

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
        myImage = myScreen.getMyTurtle().getTurtleImage();
        myX = myTurtle.getXCor();
        myY = myTurtle.getYCor();

        myMenu = new MenuBar();
        createMenu = new CreateColorMenu(myColorGraphics, 600, 600);
        myMenu.getMenus().add(createMenu.getColorMenu());
        myTurtleImages = new CreateTurtleSelectionMenu(myTurtle);
        myMenu.getMenus().add(myTurtleImages.getImageMenu());
        myBorder.setTop(myMenu);

        // Menu menuView = new Menu("Change Color");
        // MenuItem add = new MenuItem("Blue");
        // add.setOnAction(new EventHandler<ActionEvent>() {
        // public void handle(ActionEvent e) {
        // myColorGraphics.setFill(Color.ALICEBLUE);
        // myColorGraphics.fillRect(0,0,myCanvas.getWidth(),myCanvas.getHeight());
        // }
        // });
        // menuView.getItems().add(add);
        // myMenu.getMenus().addAll(menuView);
        // myMenu.useSystemMenuBarProperty().set(true);
        // myBorder.setTop(myMenu);

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

                myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                myGraphics.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                myTurtle = output.getTurtle();
                myY = myTurtle.getYCor();
                myX = myTurtle.getXCor();
                System.out.println(myTurtle.getVisibility());
                if (myTurtle.getVisibility() == 1) {
                    myGraphics.drawImage(myTurtle.getTurtleImage(), myX, myY);
                }
                else {
                    myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                }

                rotate(myGraphics, myTurtle.getHeading(), calculatePivotX(),
                       calculatePivotY());
                myGraphics.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                myGraphics.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());

                myGraphics.drawImage(myTurtle.getTurtleImage(), myTurtle.getXCor(),
                                     myTurtle.getYCor());

            }
        });
    }
    private double calculatePivotX(){
        return (myTurtle.getXCor() + (myTurtle.getTurtleImage().getWidth() / 2));
    }
    
    private double calculatePivotY(){
        return (myTurtle.getYCor() + (myTurtle.getTurtleImage().getHeight() / 2));
    }
    private void rotate (GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    public Scene getScene () {
        return myScene;
    }
}
