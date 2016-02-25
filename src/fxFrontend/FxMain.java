package fxFrontend;
import javafx.application.Application;
import javafx.stage.Stage;

public class FxMain extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	Display myDisplay = new Display();
        primaryStage.setScene(myDisplay.getScene());
        primaryStage.show();
    }
    
    
    
}
