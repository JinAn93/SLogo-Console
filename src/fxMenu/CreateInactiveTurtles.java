package fxMenu;
import java.util.*;
import Turtle.*;
import fxFrontend.Display;
import fxFrontend.Display.ObserveTurtle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class CreateInactiveTurtles {
	private List<Integer> myInactiveList;
	private List<SingleTurtle> myTurtleList;
	private Menu myTurtleInactiveMenu;
	private MenuItem myChoose;
	private Button myButton; 
	private TextField myInput;
	private ArrayList<Integer> myIndices; 
	private String myCommand; 
	
	public CreateInactiveTurtles(List<Integer> mynumlist, List<SingleTurtle> myturts){
		myTurtleInactiveMenu = new Menu("Choose Inactive Turtles");
		myTurtleList = myturts;
		myInactiveList = mynumlist;
		getOptions();
		myTurtleInactiveMenu.getItems().add(myChoose);	
	}
	
	private void getOptions(){
		myChoose = new MenuItem("Choose the inactive turtles");
        myChoose.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	Stage myTempStage = new Stage();
            	Pane root = new Pane();
            	Scene myScene = new Scene(root,300,200);
            	HBox myBox = new HBox();
            	myInput = new TextField();
                myButton = new Button("Submit");
            	myBox.getChildren().addAll(myInput,myButton);
            	root.getChildren().add(myBox);
            	myTempStage.setScene(myScene);
            	myTempStage.show();
            	pickTurtle();
            }
        });

	}
	
    private void pickTurtle() {
    	myButton.setOnAction(new EventHandler<ActionEvent>(){
    		public void handle(ActionEvent event) {
    			String myInputCommand = myInput.getText();
    			String[] mySplit = myInputCommand.split(" ");
    			myCommand = mySplit[0];
    			String[] myIndicesString = mySplit[1].split(",");
    			myIndices = new ArrayList<Integer>();
    			for(String astring: myIndicesString){
    				myIndices.add(Integer.parseInt(astring));}
    			commandCheck();
    			for(int i=0; i<myTurtleList.size(); i++){
    				if(myInactiveList.contains(i)){
    					myTurtleList.get(i).setActive(false);
    				}else{
    					myTurtleList.get(i).setActive(true);}
    			}
    		}
    	});
    }
    
    private void commandCheck() {
		if(myCommand.equals("inactive")){
			iterateInactive();
		}else if(myCommand.equals("active")){
			iterateActive();
		}
	}

    private void iterateActive() {
		for(Integer anint: new ArrayList<Integer>(myIndices)){
			if(myInactiveList.contains(anint)){
				myInactiveList.remove(anint);
			}
		}
	}

	private void iterateInactive() {
		for(Integer anint: myIndices){
			if(!myInactiveList.contains(anint)){
				myInactiveList.add(anint);
			}
		}
	}
    
	public Menu getMenu(){
		return myTurtleInactiveMenu;
	}
}
