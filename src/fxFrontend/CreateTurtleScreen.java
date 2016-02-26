package fxFrontend;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CreateTurtleScreen {
	
	private VBox myScreen;
	private Button myButton;
	private StackPane root = new StackPane(); 
	private TextField codeInput; 
	private Canvas myCanvas;
	private GraphicsContext myGraphics;
	private Image myTurtleImage;
	public CreateTurtleScreen(){
		myScreen = new VBox(20);
		myScreen.setPadding(new Insets(0, 20, 10, 20)); 

		myCanvas = new Canvas(600,600);
		myGraphics = myCanvas.getGraphicsContext2D();
		myGraphics.setFill(Color.WHITE);
		myGraphics.fillRect(0,0,myCanvas.getWidth(),myCanvas.getHeight());
        myScreen.getChildren().add(myCanvas);
        Image img = new Image("/fxFrontend/turtle.png");
        myGraphics.drawImage(img, 0, 0);
        
        Label label1 = new Label("Code input:");
        codeInput = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, codeInput);
        hb.setSpacing(10);
        myScreen.getChildren().add(hb);
        
        myButton = new Button("Submit");
        myScreen.getChildren().add(myButton);
	}
	public VBox getScreen(){
		return myScreen;
	}
	
	public Button getButton(){
		return myButton;
	}
	
	public TextField getCodeInput(){
		return codeInput; 
	}
}