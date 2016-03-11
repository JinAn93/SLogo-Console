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
	private GraphicsContext graphics; 
	
	public DisplayUpdater(List<SingleTurtle> myTurts, GraphicsContext gc){
		myTurtleList = myTurts;
		graphics = gc; 
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
	
	public void updateTurtle(){
		 int a = 0;
	        double[] xCoor = new double[myTurtleList.size()];
	        double[] yCoor = new double[myTurtleList.size()];
	        double[] head = new double[myTurtleList.size()];
	        int[] visib = new int[myTurtleList.size()];
	        graphics.clearRect(0, 0, 600, 600);
	        graphics.fillRect(0, 0, 600, 600);

	        for (Turtle aturtle : myTurtleList) {
	            xCoor[a] = aturtle.getEndXCor();
	            yCoor[a] = aturtle.getEndYCor();
	            head[a] = aturtle.getHeading();
	            visib[a] = aturtle.getVisibility();
	            a++;
	        }
	        a = 0;
	        for (Turtle aturtle : myTurtleList) {
	            if (visib[a] == 1) {
	            	 graphics.drawImage(aturtle.getTurtleImage(), xCoor[a], yCoor[a]);
	            }
	            rotate(graphics, head[a], calculatePivotX(aturtle), calculatePivotY(aturtle));
	            a++;
	        }
	}
	
	private void rotate (GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
	
	private double calculatePivotX (Turtle turtle) {
        return (turtle.getStartXCor() + (turtle.getTurtleImage().getWidth() / 2));
    }

    private double calculatePivotY (Turtle turtle) {
        return (turtle.getStartYCor() + (turtle.getTurtleImage().getHeight() / 2));
    }
}
