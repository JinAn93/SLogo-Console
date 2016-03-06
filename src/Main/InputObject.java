package Main;

import java.util.ResourceBundle;

import Main.Turtle;


public class InputObject {
    private String myCommand;
    private Turtle myTurtle;
    private ResourceBundle myLanguage;
    
    public InputObject (String command, Turtle turtle, ResourceBundle language) {
        myCommand = command;
        myTurtle = turtle;
        myLanguage = language;
    }
    
    public InputObject(ResourceBundle language){
        myLanguage = language;
    }
    
    public void setCommand(String command){
        myCommand = command;
    }
    
    public void setTurtle(Turtle turtle){
        myTurtle = turtle; 
    }
    
    public String getCommand () {
        return myCommand;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
    
    public void setLanguage(ResourceBundle bundle){
    	myLanguage = bundle; 
    }
    
    public ResourceBundle getLanguage(){
    	return myLanguage; 
    }

}
