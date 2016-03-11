package fxFrontend;
import BackEndMain.*;
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
import java.io.Serializable;
import java.util.*;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.*;
import Error_Checking.ErrorObject;
import fxMenu.SlogoMenuCreator;
import javafx.scene.transform.Rotate;
import fxFrontend.Line;
import fxFrontend.LanguageReader;

public class DisplayUpdater {
	private List<SingleTurtle> myTurtleList; 
	
	public DisplayUpdater(List<SingleTurtle> myTurts){
		myTurtleList = myTurts;
	}
	
	public String updateTurtleStats(){
		StringBuilder myTurtleStats = new StringBuilder();
        int i = 0;
        for (Turtle aTurtle : myTurtleList) {
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
            myTurtleStats.append("Turtle active:" + aTurtle.getActive() + "\n");
            myTurtleStats.append("\n");
            i++;
        }
        return myTurtleStats.toString(); 
	}
}
