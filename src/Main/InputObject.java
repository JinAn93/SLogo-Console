package Main;

import java.util.List;
import java.util.ResourceBundle;
import Main.Turtle;


public class InputObject {
    private String myCommand;
    private List<Turtle> myAllTurtles;
    private ResourceBundle myLanguage;
    
    public InputObject (String command, List<Turtle> turtle, ResourceBundle language) {
        myCommand = command;
        myAllTurtles = turtle;
        myLanguage = language;
    }
    
    public InputObject(ResourceBundle language){
        myLanguage = language;
    }
    
    public void setCommand(String command){
        myCommand = command;
    }
    
    public void setTurtle(List<Turtle> turtle){
        myAllTurtles = turtle; 
    }
    
    public String getCommand () {
        return myCommand;
    }

    public List<Turtle> getTurtle () {
        return myAllTurtles;
    }
    
    public void setLanguage(ResourceBundle bundle){
    	myLanguage = bundle; 
    }
    
    public ResourceBundle getLanguage(){
    	return myLanguage; 
    }

}
