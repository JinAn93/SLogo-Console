package fxFrontend;
import fxFrontend.Display.ObserveTurtle;
import javafx.application.Application;
import javafx.stage.Stage;

public class FxMain extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	Display myDisplay = new Display();
    	ObserveTurtle obTurtle = myDisplay.new ObserveTurtle();
    	myDisplay.getTurtle().get(0).addObserver(obTurtle);
    	myDisplay.getTurtle().get(1).addObserver(obTurtle);
        primaryStage.setScene(myDisplay.getScene());
        primaryStage.show();
    }
}