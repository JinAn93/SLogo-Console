package fxMenu;

import java.util.List;
import java.util.Optional;

import Turtle.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;


public class CreatePenPropertiesMenu {
    private List<SingleTurtle> myTurtle;
    private Menu myPenUpMenu;
    private MenuItem setPenDown, setPenUp, setPenWidth, setDashedLines;

    public CreatePenPropertiesMenu (List<SingleTurtle> turt) {
        myTurtle = turt;
        myPenUpMenu = new Menu("Pen Properties");
        setPenDown = new MenuItem("Set Pen Down");
        setPenUp = new MenuItem("Set Pen Up");
        setPenWidth = new MenuItem("Set Pen Width");
        setDashedLines = new MenuItem("Enable Dashed Lines");
        dashLineMenu();   
        penDownMenu();
        penUpMenu();
        penWidthMenu();
        myPenUpMenu.getItems().add(setPenDown);
        myPenUpMenu.getItems().add(setPenUp);
        myPenUpMenu.getItems().add(setPenWidth);
        myPenUpMenu.getItems().add(setDashedLines);
    }

	private void penWidthMenu() {
		setPenWidth.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
            	TextInputDialog dialog = new TextInputDialog("");
            	dialog.setTitle("Pen Width");
            	dialog.setHeaderText("Choose Pen Width");
            	dialog.setContentText("Please choose a pen width:");
            	Optional<String> result = dialog.showAndWait();
            	int useResult = Integer.parseInt(result.get());
                for (Turtle aturtle : myTurtle)
                    aturtle.setPenWidth(useResult);
            }
        });
	}

	private void penUpMenu() {
		setPenUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                for (Turtle aturtle : myTurtle)
                    aturtle.setPen(0);
            }
        });
	}

	private void penDownMenu() {
		setPenDown.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                for (Turtle aturtle : myTurtle)
                    aturtle.setPen(1);
            }
        });
	}

	private void dashLineMenu() {
		setDashedLines.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                for (Turtle aturtle : myTurtle)
                    aturtle.setPenDashed();
            }
        });
	}

    public Menu getPenUpMenu () {
        return myPenUpMenu;
    }

}
