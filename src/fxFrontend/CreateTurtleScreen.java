package fxFrontend;

import Main.Turtle;
import javafx.geometry.Insets;
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

public class CreateTurtleScreen {
	
	private VBox myScreen;
	private Button myButton;
	private TextArea codeInput; 
	private Canvas myCanvas, myCanvas2, myLineCanvas;
	private GraphicsContext myGraphics, myGraphics2, myLineGraphics;
	private Image myTurtleImage;
//	private int turtleX,turtleY;
	private Turtle myTurtle; 
	private StackPane myPane;
//	private HashMap<>
	
	public CreateTurtleScreen(){
		myScreen = new VBox(20);
		myScreen.setPadding(new Insets(0, 20, 10, 20)); 
		
		myPane = new StackPane();
		
		myCanvas = new Canvas(600,600);
		myGraphics = myCanvas.getGraphicsContext2D();
		myGraphics.setFill(Color.TRANSPARENT);
		myGraphics.fillRect(0,0,myCanvas.getWidth(),myCanvas.getHeight());
		        
        myTurtle = new Turtle(180, 210, "/resources/koopa.png");
        myGraphics.drawImage(myTurtle.getTurtleImage(), myTurtle.getStartXCor(), myTurtle.getStartYCor());
        
		myCanvas2 = new Canvas(600,600);
		myGraphics2 = myCanvas2.getGraphicsContext2D();
		myGraphics2.setFill(Color.WHITE);
		myGraphics2.fillRect(0,0,myCanvas2.getWidth(),myCanvas2.getHeight());
		
		myLineCanvas = new Canvas(600,600);
		myLineGraphics = myLineCanvas.getGraphicsContext2D();
		myLineGraphics.setFill(Color.TRANSPARENT);
		myLineGraphics.fillRect(0,0,myLineCanvas.getWidth(),myLineCanvas.getHeight());

		
		myPane.getChildren().add(myCanvas2);
		myPane.getChildren().add(myLineCanvas);
		myPane.getChildren().add(myCanvas);
		myScreen.getChildren().add(myPane);

        
        Label label1 = new Label("Code:");
        codeInput = new TextArea ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, codeInput);
        hb.setSpacing(10);
        myScreen.getChildren().add(hb);
        
        myButton = new Button("Submit");
        myScreen.getChildren().add(myButton);
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
	
	public Turtle getMyTurtle(){
		return myTurtle;
	}
	
	public GraphicsContext getLineGraphics(){
		return myLineGraphics;
	}
	
}