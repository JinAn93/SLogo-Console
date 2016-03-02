package Main;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorObject {
	private String errorMessage; 
	private String errorType; 
	private Alert alert = new Alert(AlertType.INFORMATION);
	
	public ErrorObject(String type, String error){
		errorType = type; 
		errorMessage = error; 
	}
	
	public void displayError(){
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error processing the command: " + errorType);
		alert.setContentText(errorMessage);
		alert.showAndWait();
	}
}
