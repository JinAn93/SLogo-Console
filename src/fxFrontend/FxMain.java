package fxFrontend;

import java.util.Optional;
import BackEndMain.StrConstant;
import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;
import fxFrontend.Display.ObserveTurtle;


public class FxMain extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) {
        String[] choices =
                { StrConstant.NUM_TURTLE_ONE, StrConstant.NUM_TURTLE_TWO,
                 StrConstant.NUM_TURTLE_THREE, StrConstant.NUM_TURTLE_FOUR };
        ChoiceDialog<String> dialog = new ChoiceDialog<>(StrConstant.NUM_TURTLE_ONE, choices);
        dialog.setTitle(StrConstant.TITLE);
        dialog.setHeaderText(StrConstant.HEADER);
        dialog.setContentText(StrConstant.CONTENT);
        Optional<String> result = dialog.showAndWait();
        String toUse = result.get();
        Integer useNum = Integer.parseInt(toUse);
        Display myDisplay = new Display(useNum);
        ObserveTurtle obTurtle = myDisplay.new ObserveTurtle();
        for (int turtleID = 0; turtleID < useNum; turtleID++) {
            myDisplay.getTurtle().get(turtleID).addObserver(obTurtle);
        }
        primaryStage.setScene(myDisplay.getScene());
        primaryStage.show();
    }
}
