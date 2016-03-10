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

    public CreatePenPropertiesMenu (List<SingleTurtle> turt) {
        myTurtle = turt;
        myPenUpMenu = new Menu("Set Pen Up/Down");
        MenuItem setPenDown = new MenuItem("Set Pen Down");
        MenuItem setPenUp = new MenuItem("Set Pen Up");
        MenuItem setPenWidth = new MenuItem("Set Pen Width");

        setPenDown.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                for (Turtle aturtle : myTurtle)
                    aturtle.setPen(1);
            }
        });

        setPenUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle (ActionEvent e) {
                for (Turtle aturtle : myTurtle)
                    aturtle.setPen(0);
            }
        });

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

        myPenUpMenu.getItems().add(setPenDown);
        myPenUpMenu.getItems().add(setPenUp);
        myPenUpMenu.getItems().add(setPenWidth);
    }

    public Menu getPenUpMenu () {
        return myPenUpMenu;
    }

}
