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
    	myDisplay.getTurtle().addObserver(obTurtle);
        primaryStage.setScene(myDisplay.getScene());
        primaryStage.show();
    }
}