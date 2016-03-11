package Error_Checking;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * Serves to create error message dialog. 
 * 
 * @author Cody Li
 *
 */
public class ErrorObject {
    private String errorMessage;
    private Alert alert = new Alert(AlertType.INFORMATION);

    public ErrorObject (String error) {
        errorMessage = error;
    }

    public void displayError () {
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Error processing the command.");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
