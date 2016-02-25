package fxFrontend;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class main extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	VBox testy = createVBox();
	VBox centery = createCenter();
	VBox righty = createConsole();
    BorderPane bp = new BorderPane();
    bp.setPadding(new Insets(10, 20, 10, 20));

    Button btnLeft = new Button("Left");
    bp.setLeft(testy);

    Button btnCenter = new Button("Center");
    bp.setCenter(centery);

    Button btnRight = new Button("Right");
    bp.setRight(righty);

    Scene scene = new Scene(bp, 1050, 800);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public VBox createVBox(){
	     VBox vbox = new VBox(20); // spacing = 8
	     
	     final TextArea textArea = new TextArea();
	     Label label1 = new Label("Turtle Stats:");
	     vbox.getChildren().add(label1);
	     ScrollPane scrollPane = new ScrollPane();
	     scrollPane.setContent(textArea);
	     scrollPane.setFitToWidth(true);
         scrollPane.setPrefWidth(200);
	     scrollPane.setPrefHeight(180);
	     vbox.getChildren().add(scrollPane);
	     
	     final TextArea textArea2 = new TextArea();
	     Label label2 = new Label("User commands:");
	     vbox.getChildren().add(label2);
	     ScrollPane scrollPane2 = new ScrollPane();
	     scrollPane2.setContent(textArea2);
	     scrollPane2.setFitToWidth(true);
         scrollPane2.setPrefWidth(200);
	     scrollPane2.setPrefHeight(180);
	     vbox.getChildren().add(scrollPane2);
	     
	     final TextArea textArea3 = new TextArea();
	     Label label3 = new Label("Variables:");
	     vbox.getChildren().add(label3);
	     ScrollPane scrollPane3 = new ScrollPane();
	     scrollPane3.setContent(textArea3);
	     scrollPane3.setFitToWidth(true);
         scrollPane3.setPrefWidth(200);
	     scrollPane3.setPrefHeight(180);
	     vbox.getChildren().add(scrollPane3);
	     
	     return vbox;
  }
  
  public VBox createCenter(){
	  VBox toRet = new VBox(20);
      Canvas canvas = new Canvas(600,600);
      GraphicsContext gc = canvas.getGraphicsContext2D();
      gc.setFill(Color.WHITE);
      gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
      toRet.getChildren().add(canvas);
      
      Label label1 = new Label("Code input:");
      TextField textField = new TextField ();
      HBox hb = new HBox();
      hb.getChildren().addAll(label1, textField);
      hb.setSpacing(10);
      toRet.getChildren().add(hb);
      
      Button submit = new Button("Submit");
      toRet.getChildren().add(submit);
	  return toRet;
  }
  
  public VBox createConsole(){
	   VBox vbox = new VBox(20); // spacing = 8
	     
	   final TextArea textArea = new TextArea();
	   textArea.setPrefSize(200, 500);
	   Label label1 = new Label("History:");
	   vbox.getChildren().add(label1);
	   ScrollPane scrollPane = new ScrollPane();
	   scrollPane.setContent(textArea);
	   scrollPane.setFitToWidth(true);
       scrollPane.setPrefWidth(200);
	   scrollPane.setPrefHeight(500);
	   vbox.getChildren().add(scrollPane);
	   
	   final TextArea textArea2 = new TextArea();
	   Label label2 = new Label("Console:");
	   vbox.getChildren().add(label2);
	   ScrollPane scrollPane2 = new ScrollPane();
	   scrollPane2.setContent(textArea2);
	   scrollPane2.setFitToWidth(true);
       scrollPane2.setPrefWidth(200);
	   scrollPane2.setPrefHeight(150);
	   vbox.getChildren().add(scrollPane2);

	  return vbox;
  }
  
}
