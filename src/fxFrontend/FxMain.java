package fxFrontend;
import fxFrontend.Display.ObserveTurtle;
import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;
import java.util.*;
public class FxMain extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	List<String> choices = new ArrayList<>();
    	choices.add("1");
    	choices.add("2");
    	choices.add("3");

    	ChoiceDialog<String> dialog = new ChoiceDialog<>("1", choices);
    	dialog.setTitle("Slogo");
    	dialog.setHeaderText("Turtle Options");
    	dialog.setContentText("Choose your Number of Turtles:");

    	// Traditional way to get the response value.
    	Optional<String> result = dialog.showAndWait();
    	String toUse = result.get();
    	Integer useNum = Integer.parseInt(toUse);
    	Display myDisplay = new Display(useNum);
    	ObserveTurtle obTurtle = myDisplay.new ObserveTurtle();
    	for(int i=0;i<useNum;i++){
    		myDisplay.getTurtle().get(i).addObserver(obTurtle);
    	}
//    	myDisplay.getTurtle().get(0).addObserver(obTurtle);
//    	myDisplay.getTurtle().get(1).addObserver(obTurtle);
        primaryStage.setScene(myDisplay.getScene());
        primaryStage.show();
    }
}