package fxFrontend;

import Turtle.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.*;
public class TurtleScreen {
	
	private VBox myScreen;
	private Button myButton;
	private TextArea codeInput; 
	private Canvas myCanvas = new Canvas(600, 600);
	private Canvas myCanvas2 = new Canvas(600, 600);
	private Canvas myLineCanvas = new Canvas(600, 600);;
	private GraphicsContext myGraphics, myGraphics2, myLineGraphics;
	private Image myTurtleImage;
	private List<SingleTurtle> myTurtle; 
	private StackPane myPane;
	private int myNumTurtles;
	private int yVal = 100;
	private HBox hb; 
	
	public TurtleScreen(int nummy){
		myScreen = new VBox(20);
		myScreen.setPadding(new Insets(0, 20, 10, 20)); 
		myNumTurtles = nummy;
		myPane = new StackPane();
		myGraphics = myCanvas.getGraphicsContext2D();
		myGraphics2 = myCanvas2.getGraphicsContext2D();
		myLineGraphics = myLineCanvas.getGraphicsContext2D();		
		drawTurtle();		
		createDisplayLayer(myCanvas, myGraphics, Color.TRANSPARENT);
		createDisplayLayer(myCanvas2, myGraphics2, Color.WHITE);
		createDisplayLayer(myLineCanvas, myLineGraphics, Color.TRANSPARENT);		
		createPane();
        Label label1 = new Label("Code:");
        codeInput = new TextArea ();
        hb = new HBox();
        hb.getChildren().addAll(label1, codeInput);
        hb.setSpacing(10);
        addToDisplay();
	}

	private void addToDisplay() {
		myScreen.getChildren().add(hb);     
        myButton = new Button("Submit");
        myScreen.getChildren().add(myButton);
	}
	
	private void createDisplayLayer(Canvas canvas, GraphicsContext graphics, Color color){
		graphics.setFill(color);
		graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
	}
	
	private void createPane() {
		myPane.getChildren().add(myCanvas2);
		myPane.getChildren().add(myLineCanvas);
		myPane.getChildren().add(myCanvas);
		myScreen.getChildren().add(myPane);
	}
	
	private void drawTurtle() {
		myTurtle = new ArrayList<SingleTurtle>();
		for(int i=0;i<myNumTurtles;i++){
			myTurtle.add(new SingleTurtle(180,yVal,"/resources/koopa.png"));
			yVal +=100;
		}
        for(Turtle aTurtle: myTurtle){
        	myGraphics.drawImage(aTurtle.getTurtleImage(), aTurtle.getStartXCor(), aTurtle.getStartYCor());
        }
	}
	
	public Canvas getCanvas(){
		return myCanvas2;
	}
	public VBox getScreen(){
		return myScreen;
	}
	
	public Button getButton(){
		return myButton;
	}
	
	public TextArea getCodeInput(){
		return codeInput; 
	}
	
	public GraphicsContext getGraphics(){
		return myGraphics;
	}
	
	public GraphicsContext getColorGraphics(){
		return myGraphics2;
	}
	
	public Image getTurtleImage(){
		return myTurtleImage;
	}
	
	public List<SingleTurtle> getMyTurtle(){
		return myTurtle;
	}
	
	public GraphicsContext getLineGraphics(){
		return myLineGraphics;
	}
	
}